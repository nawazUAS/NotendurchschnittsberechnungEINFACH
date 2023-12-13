package edu.fra.uas.gatewayservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import edu.fra.uas.gatewayservice.model.ApiError;

@Service
public class FachService implements java.io.Serializable{
private static final Logger log = LoggerFactory.getLogger(FachService.class);

    @Value("${notendurchschnittsberechnungEinfach.url}")
    String apiUrl;



 public ResponseEntity<?> getAllFaecher(){
        log.debug("\"forward request to \" + apiUrl + \"/faecher\"");
         RestTemplate restTemplate = new RestTemplate();
         String url = apiUrl + "/rooms";
         HttpHeaders headers = new HttpHeaders();
         HttpEntity<String> request = new HttpEntity<String>(headers);
         ResponseEntity<?> response;

         try{
            response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        } catch (HttpClientErrorException e) {
            ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, e.getResponseBodyAsString());
            response = new ResponseEntity<>(apiError, apiError.getStatus());
        }

        return response;

}


}