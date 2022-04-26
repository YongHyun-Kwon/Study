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
		// 1. Builder ����
		SAXBuilder sb = new SAXBuilder();
		// 2. XML������ ��θ� �Է��Ͽ� XML������ Document��ü�� ����
		URL url = new URL("http://localhost/jsp_prj/day0425/create_data.xml");
		System.out.println("URLŬ������ ����� �������� �����Ͽ� ���������� �����ϴ� XML �Ľ�");
		Document doc = sb.build(url);
		System.out.println(doc);
		// 3. �ֻ������ ���
		Element rootNode = doc.getRootElement();
		System.out.println(rootNode);
		// 4. �ڽ� ���� ���
//			Element nameNode = rootNode.getChild("name");
//			System.out.println(nameNode);
		List<Element> subNodes = rootNode.getChildren();
		System.out.println("�ڽĳ���� �� " + subNodes.size());

		// 5. �Ľ��� �ڽ� ��带 �ݺ�
		Element nameNode = null;
		for (int i = 0; i < subNodes.size(); i++) {
			nameNode = subNodes.get(i);
			if ("name".equals(nameNode.getName())) {
				System.out.println("����:" + nameNode.getName() + ", ��� �� : " + nameNode.getText());
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
