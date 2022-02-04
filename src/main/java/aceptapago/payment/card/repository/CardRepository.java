package aceptapago.payment.card.repository;

import aceptapago.payment.card.model.SaveCard;
import aceptapago.payment.card.model.SelectedCard;
import oracle.jdbc.internal.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class CardRepository{

    private JdbcTemplate jdbcTemplate;
    private Integer orclCode;
    private String orclMessage;

    @Autowired
    public CardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
    * Guarda nuevas tarjetas
    * */
    public String saveCard(SaveCard card){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("MYSCHEMA")
                .withCatalogName("PA_CARD")
                .withProcedureName("PR_CREATE_CARD")
                .declareParameters(
                        new SqlParameter("aid", OracleTypes.VARCHAR),
                        new SqlParameter("cvv", OracleTypes.VARCHAR)
                );

        Map<String, Object> spParams = new HashMap<>();
        spParams.put("pa_aid", card.getPan());
        spParams.put("pa_cvv", card.getCcv());
        Map<String, Object> outParams = jdbcCall.execute(spParams);
        BigDecimal value = (BigDecimal) outParams.get("PA_CARD_ID");
        return value.toString();
    }

    public SelectedCard selectedCard(Integer cardId){
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(this.jdbcTemplate)
                .withSchemaName("MYSCHEMA")
                .withCatalogName("PA_CARD")
                .withFunctionName("FN_GET_SELECTED_CARD")
                .declareParameters(
                        new SqlParameter("pa_cardId", OracleTypes.VARCHAR),
                        new SqlParameter("pa_code", OracleTypes.NUMBER),
                        new SqlParameter("pa_message", OracleTypes.VARCHAR)
                )
                .returningResultSet("csl_cursor", BeanPropertyRowMapper.newInstance(SelectedCard.class));

    Long pa_code = 0L;
    String pa_message = "";
    Map<String, Object> fnParams = new HashMap<>();
    fnParams.put("pa_cardId", cardId);
    fnParams.put("pa_code", pa_code);
    fnParams.put("pa_message", pa_message);

    Map<String, Object> fnResult = simpleJdbcCall.execute(fnParams);

    List selectedCards = (List) fnResult.get("csl_cursor");

    return (SelectedCard) selectedCards.get(0);
    }

}
