package spms.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
1. HTTP 요청 프로토콜
문법)
요청방식 자원이름 프로토콜이름및버전 CRLF
부가정보의이름(헤더명): 값 CRLF
...
CRLF(요청의끝)

예)
GET /web01t/member/list HTTP/1.1
Host: localhost:9999
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,* /*;q=0.8
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36
Accept-Encoding: gzip,deflate,sdch
Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4

2. HTTP 응답 프로토콜
문법)
프로토콜이름및버전 상태코드 상태설명 CRLF
응답부가정보명(응답헤더명): 값 CRLF
...
CRLF(헤더의 끝)
응답내용....(Entity Body=Message Body: 응답 본문)

예)
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: text/plain;charset=UTF-8
Content-Length: 194
Date: Mon, 06 Jan 2014 04:37:52 GMT

*/
public class MyWebBrower {

	public static void main(String[] args) throws Exception {
		Socket s = new Socket("localhost", 9999);
		BufferedReader in = new BufferedReader(
				new InputStreamReader(s.getInputStream()));
		PrintStream out = new PrintStream(s.getOutputStream());
		
		out.println("GET /web01t/member/list HTTP/1.1");
		out.println("Host: localhost");
		out.println();

		int i = 0;
		while((i = in.read()) != -1) {
			System.out.print((char)i);
		}
		
		out.close();
		in.close();
		s.close();
	}

}















