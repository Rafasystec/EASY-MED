package br.com.barcadero.easymed.core.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

public class JsonUtil {
	
	public static String getJSON(Object entidade) {
        ObjectMapper mapper = new ObjectMapper();
        String result = "";

        try {
            result = mapper.writeValueAsString(entidade);
        } catch (JsonGenerationException var4) {
            var4.printStackTrace();
        } catch (JsonMappingException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

        return result;
    }

    public static <T> T transformObject(String json, Class<T> type) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        T objeto = mapper.readValue(json, type);
        return objeto;
    }

    public static <T> List<T> jsonToList(T instanceClass, String json, Class clazz) throws Exception {
    	// erro convertendo datas ficando com um dia a manos vou contiuar e depois procurar ocorreu na tela de lista de vacina
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory t = TypeFactory.defaultInstance();
        List list = (List)mapper.readValue(json, t.constructCollectionType(ArrayList.class, clazz));
        return list;
    }
}
