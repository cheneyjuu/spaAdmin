package com.swiftcode.service;

import com.google.common.collect.Lists;
import com.swiftcode.config.Constants;
import com.swiftcode.config.MyErrorHandle;
import com.swiftcode.service.dto.BottleneckDTO;
import com.swiftcode.service.dto.UserDeviceDTO;
import com.swiftcode.service.util.SapXmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.xpath.DefaultXPath;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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

    public static void main(String[] args) {
        /*String resXml = "<soap-env:Envelope xmlns:soap-env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "    <soap-env:Header/>\n" +
            "    <soap-env:Body>\n" +
            "        <n0:ZpmSearchEqunrResponse xmlns:n0=\"urn:sap-com:document:sap:soap:functions:mc-style\">\n" +
            "            <EtData>\n" +
            "                <item>\n" +
            "                    <Equnr>A1-A0-001MLJ-01</Equnr>\n" +
            "                    <Eqktx>炼胶A区1#密炼机电控柜</Eqktx>\n" +
            "                    <Tplnr>A1-A0</Tplnr>\n" +
            "                    <Pltxt>炼胶分公司A区</Pltxt>\n" +
            "                    <Boeq>否</Boeq>\n" +
            "                    <Rtime>0</Rtime>\n" +
            "                    <Swerk>A001</Swerk>\n" +
            "                    <Txtmd>贵州轮胎股份有限公司</Txtmd>\n" +
            "                    <Anlnr>000011000061</Anlnr>\n" +
            "                    <Abckz>1</Abckz>\n" +
            "                    <Abctx>关键A类设备</Abctx>\n" +
            "                </item>\n" +
            "                <item>\n" +
            "                    <Equnr>A1-A0-001MLJ-02</Equnr>\n" +
            "                    <Eqktx>test EQ1111</Eqktx>\n" +
            "                    <Tplnr>A1-A0</Tplnr>\n" +
            "                    <Pltxt>炼胶分公司A区</Pltxt>\n" +
            "                    <Boeq>否</Boeq>\n" +
            "                    <Rtime>0</Rtime>\n" +
            "                    <Swerk>A001</Swerk>\n" +
            "                    <Txtmd>贵州轮胎股份有限公司</Txtmd>\n" +
            "                    <Anlnr/>\n" +
            "                    <Abckz>2</Abckz>\n" +
            "                    <Abctx>A类设备</Abctx>\n" +
            "                </item>\n" +
            "                <item>\n" +
            "                    <Equnr>A1-A0-003MLJ</Equnr>\n" +
            "                    <Eqktx>炼胶分公司-A区-A3生产</Eqktx>\n" +
            "                    <Tplnr>A1-A0</Tplnr>\n" +
            "                    <Pltxt>炼胶分公司A区</Pltxt>\n" +
            "                    <Boeq>否</Boeq>\n" +
            "                    <Rtime>0</Rtime>\n" +
            "                    <Swerk>A001</Swerk>\n" +
            "                    <Txtmd>贵州轮胎股份有限公司</Txtmd>\n" +
            "                    <Anlnr/>\n" +
            "                    <Abckz>2</Abckz>\n" +
            "                    <Abctx>A类设备</Abctx>\n" +
            "                </item>\n" +
            "                <item>\n" +
            "                    <Equnr>A1-A0-003MLJ-1H</Equnr>\n" +
            "                    <Eqktx>炼胶分公司-A区-A3生产线-接取</Eqktx>\n" +
            "                    <Tplnr>A1-A0</Tplnr>\n" +
            "                    <Pltxt>炼胶分公司A区</Pltxt>\n" +
            "                    <Boeq>否</Boeq>\n" +
            "                    <Rtime>0</Rtime>\n" +
            "                    <Swerk>A001</Swerk>\n" +
            "                    <Txtmd>贵州轮胎股份有限公司</Txtmd>\n" +
            "                    <Anlnr>000014000042</Anlnr>\n" +
            "                    <Abckz>2</Abckz>\n" +
            "                    <Abctx>A类设备</Abctx>\n" +
            "                </item>\n" +
            "                <item>\n" +
            "                    <Equnr>A1-A0-003MLJ-1H-0C</Equnr>\n" +
            "                    <Eqktx>炼胶分公司-A区-A3生产线-接取-电机</Eqktx>\n" +
            "                    <Tplnr>A1-A0</Tplnr>\n" +
            "                    <Pltxt>炼胶分公司A区</Pltxt>\n" +
            "                    <Boeq>否</Boeq>\n" +
            "                    <Rtime>0</Rtime>\n" +
            "                    <Swerk>A001</Swerk>\n" +
            "                    <Txtmd>贵州轮胎股份有限公司</Txtmd>\n" +
            "                    <Anlnr/>\n" +
            "                    <Abckz>2</Abckz>\n" +
            "                    <Abctx>A类设备</Abctx>\n" +
            "                </item>\n" +
            "                <item>\n" +
            "                    <Equnr>A1-BO-001MLJ</Equnr>\n" +
            "                    <Eqktx>炼胶分公司-B区-B1生产线</Eqktx>\n" +
            "                    <Tplnr>A1-B0</Tplnr>\n" +
            "                    <Pltxt>炼胶分公司-B区</Pltxt>\n" +
            "                    <Boeq>否</Boeq>\n" +
            "                    <Rtime>0</Rtime>\n" +
            "                    <Swerk>A001</Swerk>\n" +
            "                    <Txtmd>贵州轮胎股份有限公司</Txtmd>\n" +
            "                    <Anlnr/>\n" +
            "                    <Abckz>3</Abckz>\n" +
            "                    <Abctx>B类设备</Abctx>\n" +
            "                </item>\n" +
            "            </EtData>\n" +
            "            <MType>S</MType>\n" +
            "            <Message>查询成功</Message>\n" +
            "        </n0:ZpmSearchEqunrResponse>\n" +
            "    </soap-env:Body>\n" +
            "</soap-env:Envelope>";
        parseDeviceXml(resXml);*/

        String xml = "<soap-env:Envelope xmlns:soap-env=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "    <soap-env:Header/>\n" +
            "    <soap-env:Body>\n" +
            "        <n0:ZpmImportEqunrResponse xmlns:n0=\"urn:sap-com:document:sap:soap:functions:mc-style\">\n" +
            "            <ItData>\n" +
            "                <item>\n" +
            "                    <Pernr>10000001</Pernr>\n" +
            "                    <Equnr>A1-A0-001MLJ-01</Equnr>\n" +
            "                    <Sdate>20191212</Sdate>\n" +
            "                    <Stime>1254</Stime>\n" +
            "                    <Edate>20191213</Edate>\n" +
            "                    <Etime>1254</Etime>\n" +
            "                    <Message/>\n" +
            "                </item>\n" +
            "            </ItData>\n" +
            "            <MType>S</MType>\n" +
            "            <Message>上传成功</Message>\n" +
            "        </n0:ZpmImportEqunrResponse>\n" +
            "    </soap-env:Body>\n" +
            "</soap-env:Envelope>";
        try {
            Document document = DocumentHelper.parseText(xml);
            DefaultXPath xpath = new DefaultXPath("//Message");
            List list = xpath.selectNodes(document);
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Element node = (Element) iterator.next();
                log.info("node: {}", node.getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private static Boolean checkImportResult(String xml) {
        try {
            Document document = DocumentHelper.parseText(xml);
            DefaultXPath xpath = new DefaultXPath("//Message");
            List list = xpath.selectNodes(document);
            for (Object o : list) {
                Element node = (Element) o;
                if (node.getText().equals("上传成功")) {
                    return true;
                }
            }
        } catch (DocumentException e) {
            throw new IllegalArgumentException("解析XML出错");
        }
        return false;
    }

    private static List<UserDeviceDTO> parseDeviceXml(String resXml) {
        List<UserDeviceDTO> dtoList = Lists.newArrayList();
        try {
            Document document = DocumentHelper.parseText(resXml);
            DefaultXPath xpath = new DefaultXPath("//EtData");
            xpath.setNamespaceURIs(Collections.singletonMap("n0", "urn:sap-com:document:sap:soap:functions:mc-style"));
            List list = xpath.selectNodes(document);
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Element node = (Element) iterator.next();
                List<Element> eleList = node.elements();
                for (Element element : eleList) {
                    List<Element> items = element.elements();
                    UserDeviceDTO dto = new UserDeviceDTO();
                    for (Element item : items) {
                        if (item.getName().equalsIgnoreCase("EQUNR")) {
                            dto.setDeviceCode(item.getText());
                        }
                        if (item.getName().equalsIgnoreCase("EQKTX")) {
                            dto.setDeviceName(item.getText());
                        }
                        if (item.getName().equalsIgnoreCase("TPLNR")) {
                            dto.setFunctionPositionCode(item.getText());
                        }
                        if (item.getName().equalsIgnoreCase("PLTXT")) {
                            dto.setFunctionPositionName(item.getText());
                        }
                        if (item.getName().equalsIgnoreCase("BOEQ")) {
                            dto.setBottleneckDevice(item.getText());
                        }
                        if (item.getName().equalsIgnoreCase("RTIME")) {
                            dto.setRestTime(item.getText());
                        }
                        if (item.getName().equalsIgnoreCase("SWERK")) {
                            dto.setFactoryCode(item.getText());
                        }
                        if (item.getName().equalsIgnoreCase("TXTMD")) {
                            dto.setFactoryName(item.getText());
                        }
                        if (item.getName().equalsIgnoreCase("ANLNR")) {
                            dto.setCareCode(item.getText());
                        }
                        if (item.getName().equalsIgnoreCase("ABCKZ")) {
                            dto.setAbcCode(item.getText());
                        }
                        if (item.getName().equalsIgnoreCase("ABCTX")) {
                            dto.setAbcName(item.getText());
                        }
                    }
                    dtoList.add(dto);
                }
            }
            log.info("list: {} size: {}", dtoList, dtoList.size());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return dtoList;
    }

    public Boolean importDevice(BottleneckDTO bottleneckDTO) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new MyErrorHandle());
        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", Constants.AUTH_CODE);
        headers.setContentType(MediaType.TEXT_XML);

        String url = sapUrl + "/sap/bc/srt/rfc/sap/zpm_import_equnr/888/zpm_import_equnr/zpm_import_equnr";
        URI uri = new URI(url);
        String xml = SapXmlUtil.buildImportDeviceXml(bottleneckDTO);

        HttpEntity<String> request = new HttpEntity<>(xml, headers);
        ResponseEntity<String> entity = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        String resXml = entity.getBody();
        Boolean result = checkImportResult(resXml);
        log.info("import result: {}", result);
        return result;
    }

    /**
     * 根据工号查找设备台账
     * @param userCode 工号
     * @return 设备台账列表
     * @throws URISyntaxException URISyntaxException
     */
    public List<UserDeviceDTO> findUserDevices(String userCode) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", Constants.AUTH_CODE);
        headers.setContentType(MediaType.TEXT_XML);

        String url = sapUrl + "/sap/bc/srt/rfc/sap/zpm_search_equnr/888/zpm_search_equnr/zpm_search_equnr";
        URI uri = new URI(url);
        String xml = SapXmlUtil.buildUserDevicesXml(userCode);

        HttpEntity<String> request = new HttpEntity<>(xml, headers);
        ResponseEntity<String> entity = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        String resXml = entity.getBody();
        return parseDeviceXml(resXml);
    }
}
