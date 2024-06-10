package org.choongang;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Clinent2 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9999);
        //클라이언트 -> 서버쪽으로 데이터 전송(동적 포트를 통해서)
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        dos.writeUTF("냥노예 응답바람");
    }
}
