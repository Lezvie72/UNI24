package api;

import properties.BaseProperties;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class SendToServer {

    public static void sendRequest() throws IOException {
        String command = "curl -X POST @" + BaseProperties.pictureDir + " 'https://dev.cp.netgowifi.com/point/marketing/banner-settings/shoko/' -H 'Cookie: _ym_uid=1559553180880469332; _ym_d=1559747120; BX_USER_ID=1e6a7a1990d4081dc4dd5040c95c7d0d; BITRIX_SM_LOGIN=test%40test.test; BITRIX_SM_SOUND_LOGIN_PLAYED=Y; _ym_isad=2; PHPSESSID=457ebcd5d51352098410f96263381ae2; _ym_visorc_45008416=w' -H 'Origin: https://dev.cp.netgowifi.com' -H 'Accept-Encoding: gzip, deflate, br' -H 'Accept-Language: ru,en;q=0.9' -H 'User-Agent: Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 YaBrowser/19.6.1.153 Yowser/2.5 Safari/537.36' -H 'Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryAAesWEScDXBqOY6A' -H 'Accept: application/json' -H 'Cache-Control: no-cache' -H 'X-Requested-With: XMLHttpRequest' -H 'Connection: keep-alive' -H 'Referer: https://dev.cp.netgowifi.com/point/marketing/banner-settings/shoko/?CODE=shoko' -H 'DNT: 1' --data-binary $'------WebKitFormBoundaryAAesWEScDXBqOY6A\\r\\nContent-Disposition: form-data; name=\"ACTION\"\\r\\n\\r\\nUPLOAD_FILE\\r\\n------WebKitFormBoundaryAAesWEScDXBqOY6A\\r\\nContent-Disposition: form-data; name=\"sessid\"\\r\\n\\r\\n94903307609202bfbbbcb24203d352ea\\r\\n------WebKitFormBoundaryAAesWEScDXBqOY6A\\r\\nContent-Disposition: form-data; name=\"ID\"\\r\\n\\r\\nnew-0\\r\\n------WebKitFormBoundaryAAesWEScDXBqOY6A\\r\\nContent-Disposition: form-data; name=\"CUSTOM_FILE\"; filename=\"344.jpg\"\\r\\nContent-Type: image/jpeg\\r\\n\\r\\n\\r\\n------WebKitFormBoundaryAAesWEScDXBqOY6A--\\r\\n' --compressed --insecure";
        Process process = Runtime.getRuntime().exec(command);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), Charset.defaultCharset()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        System.out.println(sb);

    }
}
