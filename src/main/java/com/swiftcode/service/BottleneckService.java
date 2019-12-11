package com.swiftcode.service;

import com.swiftcode.service.dto.BottleneckDTO;
import com.swiftcode.service.util.SapXmlUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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
@Service
public class BottleneckService {

    @Value("${sap-url}")
    private String sapUrl;

    public void importDevice(BottleneckDTO bottleneckDTO) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        String url = sapUrl + "/sap/bc/srt/rfc/sap/zpm_import_equnr/888/zpm_import_equnr/zpm_import_equnr";
        URI uri = new URI(url);
        String xml = SapXmlUtil.buildImportDeviceXml(bottleneckDTO);
        RequestEntity<String> requestEntity = new RequestEntity<>(xml, HttpMethod.POST, uri);
        String resXml = restTemplate.exchange(sapUrl + url, HttpMethod.POST, requestEntity, String.class).getBody();

    }
}
