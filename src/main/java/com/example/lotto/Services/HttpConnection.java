package com.example.lotto.Services;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import com.example.lotto.Model.LoteriasModel;
import com.example.lotto.Utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpConnection {
    URL url;

    public String[] getLottoName() {
        String[] lottoArray = null;

        HttpGet request = new HttpGet(Constants.BASE_URL);
        request.addHeader("accept", "application/json");

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(request)) {
            System.out.println(response.getProtocolVersion()); // HTTP/1.1
            System.out.println(response.getStatusLine().getStatusCode()); // 200
            System.out.println(response.getStatusLine().getReasonPhrase()); // OK
            System.out.println(response.getStatusLine().toString()); // HTTP/1.1 200 OK

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity);
                ObjectMapper mapper = new ObjectMapper();
                lottoArray = mapper.readValue(result, String[].class);

            }
        } catch (ParseException | IOException e) {

            e.printStackTrace();
        }
        return lottoArray;
    }

    public ArrayList<LoteriasModel> getAllConquestsOfSpecificLoto(String lotoname) {
        HttpGet request = new HttpGet(Constants.BASE_URL + lotoname);

        ArrayList<LoteriasModel> responseData = new ArrayList<LoteriasModel>();

        try (CloseableHttpClient client = HttpClients.createDefault();
                CloseableHttpResponse response = client.execute(request)) {

            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            ObjectMapper om = new ObjectMapper();
            LoteriasModel[] root = om.readValue(result, LoteriasModel[].class);

            for (LoteriasModel loteriasModel : root) {
                responseData.add(loteriasModel);
            }

            return responseData;

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public LoteriasModel getLatestConquest(String conquest) {
        HttpGet request = new HttpGet(Constants.BASE_URL + conquest + "/latest");

        CloseableHttpClient client = HttpClients.createDefault();

        try {
            CloseableHttpResponse response = client.execute(request);

            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            ObjectMapper om = new ObjectMapper();
            LoteriasModel root = om.readValue(result, LoteriasModel.class);

            return root;

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public LoteriasModel getCoquestNumber(String conquest, String number) {
        HttpGet request = new HttpGet(Constants.BASE_URL + conquest + "/" + number);

        CloseableHttpClient client = HttpClients.createDefault();

        try {
            CloseableHttpResponse response = client.execute(request);

            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            ObjectMapper om = new ObjectMapper();
            LoteriasModel root = om.readValue(result, LoteriasModel.class);

            return root;

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
