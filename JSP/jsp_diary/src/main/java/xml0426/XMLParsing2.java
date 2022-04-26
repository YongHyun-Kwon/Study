package xml0426;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLParsing2 {

	public XMLParsing2() throws JDOMException, IOException {
		// 1. Builder 생성
		SAXBuilder sb = new SAXBuilder();
		// 2. XML문서의 경로를 입력하여 XML문서를 Document객체에 저장
		URL url = new URL("http://localhost/jsp_prj/day0425/create_data.xml");
		System.out.println("URL클래스를 사용한 웹서버에 접속하여 웹서버에서 제공하는 XML 파싱");
		Document doc = sb.build(url);
		System.out.println(doc);
		// 3. 최상위노드 얻기
		Element rootNode = doc.getRootElement();
		System.out.println(rootNode);
		// 4. 자식 노드들 얻기
//			Element nameNode = rootNode.getChild("name");
//			System.out.println(nameNode);
		List<Element> subNodes = rootNode.getChildren();
		System.out.println("자식노드의 수 " + subNodes.size());

		// 5. 파싱할 자식 노드를 반복
		Element nameNode = null;
		for (int i = 0; i < subNodes.size(); i++) {
			nameNode = subNodes.get(i);
			if ("name".equals(nameNode.getName())) {
				System.out.println("노드명:" + nameNode.getName() + ", 노드 값 : " + nameNode.getText());
			}
		}
	}

	public static void main(String[] args) {

		try {
			new XMLParsing2();
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
