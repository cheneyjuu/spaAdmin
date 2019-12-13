package com.swiftcode.service.util;

import com.swiftcode.service.dto.BottleneckDTO;

/**
 * SapXmlUtil Class
 *
 * @author Ray
 * @date 2019/12/11 14:41
 */
public class SapXmlUtil {

    public static String buildImportDeviceXml(BottleneckDTO bottleneckDTO) {
        String replaceStartDate = bottleneckDTO.getStartDate().replace("-", "");
        String replaceEndDate = bottleneckDTO.getEndDate().replace("-", "");
        String replaceStartTime = bottleneckDTO.getStartTime().replace(":", "");
        String replaceEndTime = bottleneckDTO.getEndTime().replace(":", "");
        return "<Envelope xmlns=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "    <Body>\n" +
            "        <ZpmImportEqunr xmlns=\"urn:sap-com:document:sap:soap:functions:mc-style\">\n" +
            "            <ItData xmlns=\"\">\n" +
            "                <!-- Optional -->\n" +
            "                <item>\n" +
            "                    <Pernr>" + bottleneckDTO.getUserCode() + "</Pernr>\n" +
            "                    <Equnr>" + bottleneckDTO.getDeviceCode() + "</Equnr>\n" +
            "                    <Sdate>" + replaceStartDate + "</Sdate>\n" +
            "                    <Stime>" + replaceStartTime + "</Stime>\n" +
            "                    <Edate>" + replaceEndDate + "</Edate>\n" +
            "                    <Etime>" + replaceEndTime + "</Etime>\n" +
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
