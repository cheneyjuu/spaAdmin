package com.swiftcode.service.util;

import com.swiftcode.service.dto.BottleneckDTO;

import java.text.SimpleDateFormat;

/**
 * SapXmlUtil Class
 *
 * @author Ray
 * @date 2019/12/11 14:41
 */
public class SapXmlUtil {

    public static String buildImportDeviceXml(BottleneckDTO bottleneckDTO) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "    <Body>\n" +
            "        <ZpmImportEqunr xmlns=\"urn:sap-com:document:sap:soap:functions:mc-style\">\n" +
            "            <ItData xmlns=\"\">\n" +
            "                <!-- Optional -->\n" +
            "                <item>\n" +
            "                    <Pernr>"+bottleneckDTO.getUserCode()+"</Pernr>\n" +
            "                    <Equnr>"+bottleneckDTO.getDeviceCode()+"</Equnr>\n" +
            "                    <Sdate>"+new SimpleDateFormat("yyyy.MM.dd").format(bottleneckDTO.getStartTime())+"</Sdate>\n" +
            "                    <Stime></Stime>\n" +
            "                    <Edate>"+new SimpleDateFormat("yyyy.MM.dd").format(bottleneckDTO.getEndTime())+"</Edate>\n" +
            "                    <Etime></Etime>\n" +
            "                    <Message></Message>\n" +
            "                </item>\n" +
            "            </ItData>\n" +
            "        </ZpmImportEqunr>\n" +
            "    </Body>\n" +
            "</Envelope>";
    }
}
