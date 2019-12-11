package com.swiftcode.service;

import com.swiftcode.service.dto.BottleneckDTO;
import com.swiftcode.service.util.SapXmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * BottleneckService Class
 *
 * @author Ray
 * @date 2019/12/11 14:38
 */
@Slf4j
@Service
public class BottleneckService {

    @Value("${sap-url}")
    private String sapUrl;

    public void importDevice(BottleneckDTO bottleneckDTO) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", "Basic RGV2MDM6MTIzNDU2");
        headers.setContentType(MediaType.TEXT_XML);

        String url = sapUrl + "/sap/bc/srt/rfc/sap/zpm_import_equnr/888/zpm_import_equnr/zpm_import_equnr";
        URI uri = new URI(url);
        String xml = SapXmlUtil.buildImportDeviceXml(bottleneckDTO);

        HttpEntity<String> request = new HttpEntity<>(xml, headers);
        ResponseEntity<String> entity = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        String resXml = entity.getBody();
        log.info("import result: {}", resXml);
    }

    public void findUserDevices(String userCode) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", "Basic RGV2MDM6MTIzNDU2");
        headers.setContentType(MediaType.TEXT_XML);

        String url = sapUrl + "/sap/bc/srt/rfc/sap/zpm_search_equnr/888/zpm_search_equnr/zpm_search_equnr";
        URI uri = new URI(url);
        String xml = SapXmlUtil.buildUserDevicesXml(userCode);

        HttpEntity<String> request = new HttpEntity<>(xml, headers);
        ResponseEntity<String> entity = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        log.info("entity: {}", entity);
        String resXml = entity.getBody();
        log.info("find user devices: {}", resXml);
    }
}
