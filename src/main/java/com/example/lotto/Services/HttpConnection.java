package com.example.lotto.Services;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.*;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.*;

import com.example.lotto.Model.Dezenas;
import com.example.lotto.Model.LoteriasModel;
import com.example.lotto.Utils.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class HttpConnection {
    HttpClient client = HttpClient.newHttpClient();

    URL url;

    public List<String> getLottoName() {
        List<String> lotoArray;

        HttpRequest request = HttpRequest.newBuilder(URI.create(Constants.BASE_URL))
                .header("accept", "application/json").GET().build();

        try {
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String data = response.body().toString();
            String data1 = data.replace("[", "");
            String data2 = data1.replace("]", "");
            String data3 = data2.replace("\"", "");
            lotoArray = new ArrayList<>(Arrays.asList(data3.split(",")));

            return lotoArray;

        } catch (IOException | InterruptedException e) {

            System.out.println(e);
        }
        return Collections.emptyList();
    }

    public ArrayList<LoteriasModel> getAllConquestsOfSpecificLoto(String lotoname) {
        HttpGet request = new HttpGet(Constants.BASE_URL + lotoname);

        CloseableHttpClient client = HttpClients.createDefault();
        ArrayList<LoteriasModel> responseData = new ArrayList<LoteriasModel>();

        try {
            CloseableHttpResponse response = client.execute(request);

            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);

            ObjectMapper om = new ObjectMapper();
            LoteriasModel[] root = om.readValue(result, LoteriasModel[].class);

            for (LoteriasModel loteriasModel : root) {
                responseData.add(loteriasModel);
            }

            return responseData;

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
