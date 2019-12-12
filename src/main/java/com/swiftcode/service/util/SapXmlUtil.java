package com.swiftcode.service.util;

import com.swiftcode.service.dto.BottleneckDTO;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * SapXmlUtil Class
 *
 * @author Ray
 * @date 2019/12/11 14:41
 */
public class SapXmlUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd");

    public static String buildImportDeviceXml(BottleneckDTO bottleneckDTO) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "    <Body>\n" +
            "        <ZpmImportEqunr xmlns=\"urn:sap-com:document:sap:soap:functions:mc-style\">\n" +
            "            <ItData xmlns=\"\">\n" +
            "                <!-- Optional -->\n" +
            "                <item>\n" +
            "                    <Pernr>" + bottleneckDTO.getUserCode() + "</Pernr>\n" +
            "                    <Equnr>" + bottleneckDTO.getDeviceCode() + "</Equnr>\n" +
            "                    <Sdate>" + bottleneckDTO.getStartTime().format(FORMATTER) + "</Sdate>\n" +
            "                    <Stime></Stime>\n" +
            "                    <Edate>" + bottleneckDTO.getEndTime().format(FORMATTER) + "</Edate>\n" +
            "                    <Etime></Etime>\n" +
            "                    <Message></Message>\n" +
            "                </item>\n" +
            "            </ItData>\n" +
            "        </ZpmImportEqunr>\n" +
            "    </Body>\n" +
            "</Envelope>";
    }

    public static String buildUserDevicesXml(String userCode) {
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "    <Body>\n" +
            "        <ZpmSearchEqunr xmlns=\"urn:sap-com:document:sap:soap:functions:mc-style\">\n" +
            "            <EtData xmlns=\"\">\n" +
            "            </EtData>\n" +
            "            <Pernr xmlns=\"\">" + userCode + "</Pernr>\n" +
            "        </ZpmSearchEqunr>\n" +
            "    </Body>\n" +
            "</Envelope>";
    }
}
