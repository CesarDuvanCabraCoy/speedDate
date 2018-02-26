package perssistence;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import models.ConstantsMod;
import models.User;
import utils.Utils;

public class ManagerXml {

	Document document;
	private String path;

	public ManagerXml() {
		this.path = ConstantsMod.NAME_AFFINITY_FILE_USERS;
	}

	public void readFileXml() throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		document = docBuilder.parse(new File(path));
		document.getDocumentElement().normalize();
	}

	private Element writeUser(Document doc, Element elementUser, User user) {
		Element id = doc.createElement("id");
		Text nodeId = doc.createTextNode(String.valueOf(user.getId()));
		id.appendChild(nodeId);

		Element name = doc.createElement("name");
		Text nodeName = doc.createTextNode(String.valueOf(user.getName()));
		name.appendChild(nodeName);

		Element bornDate = doc.createElement("bornDate");
		Text nodeBornDate = doc.createTextNode(toStringCalendar(user.getBornDate()));
		bornDate.appendChild(nodeBornDate);

		Element city = doc.createElement("city");
		Text nodeCity = doc.createTextNode(String.valueOf(user.getCity()));
		city.appendChild(nodeCity);

		Element myGender = doc.createElement("myGender");
		Text nodeMyGender = doc.createTextNode(String.valueOf(user.getMyGender()));
		myGender.appendChild(nodeMyGender);

		Element genderAffinity = doc.createElement("genderAffinity");
		Text nodeGenderAffinity = doc.createTextNode(String.valueOf(user.getGenderAffinity()));
		genderAffinity.appendChild(nodeGenderAffinity);

		Element sport = doc.createElement("sport");
		Text nodeSport = doc.createTextNode(String.valueOf(user.getSport()));
		sport.appendChild(nodeSport);

		Element musicGender = doc.createElement("musicGender");
		Text nodeMusicGender = doc.createTextNode(String.valueOf(user.getMusicGender()));
		musicGender.appendChild(nodeMusicGender);

		elementUser.appendChild(id);
		elementUser.appendChild(name);
		elementUser.appendChild(bornDate);
		elementUser.appendChild(city);
		elementUser.appendChild(myGender);
		elementUser.appendChild(genderAffinity);
		elementUser.appendChild(sport);
		elementUser.appendChild(musicGender);
		return elementUser;
	}

	public static String toStringCalendar(Calendar calendar){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/YYYY");
		String date = simpleDateFormat.format(calendar.getTime());
		return date;
	}
	
	public void writeAllUsers(ArrayList<User> users) throws TransformerFactoryConfigurationError,
										ParserConfigurationException, TransformerException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		DOMImplementation implementation = builder.getDOMImplementation();
		Document document = implementation.createDocument(null, ConstantsMod.NAME_AFFINITY, null);
		document.setXmlVersion("1.0");
		Source source = new DOMSource(document);

		Element root = document.getDocumentElement();
		for (User user : users) {
			Element elementParking = document.createElement("user");
			root.appendChild(writeUser(document, elementParking, user));			
		}
		StreamResult result = new StreamResult(new File(ConstantsMod.NAME_AFFINITY_FILE_USERS));
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.transform(source, result);
	}
	
	public ArrayList<User> parserDocumentToGetUsers() throws ParserConfigurationException, SAXException, IOException{
		readFileXml();
		NodeList nodeList = document.getElementsByTagName("user");
		ArrayList<User> listParkingsAux = new ArrayList<User>();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			User newUser = Utils.getUser(element);	
			listParkingsAux.add(newUser);
		}
		return listParkingsAux;
	}

	public static void main(String[] args) {
//		ManagerXml manager = new ManagerXml();
//		ArrayList<User> users = new ArrayList<User>();
//		User user1 = new User(1, "Duvan", new GregorianCalendar(2000, 11, 20), City.Tunja, Gender.HOMBRE, Gender.MUJER, Sport.FUTBOL, MusicGender.VALLENATO);
//		User user2 = new User(1, "Linda", new GregorianCalendar(2000, 11, 20), City.Tunja, Gender.HOMBRE, Gender.MUJER, Sport.FUTBOL, MusicGender.VALLENATO);
//		User user3 = new User(1, "Andrea", new GregorianCalendar(2000, 11, 20), City.Tunja, Gender.HOMBRE, Gender.MUJER, Sport.FUTBOL, MusicGender.VALLENATO);
//		users.add(user1);
//		users.add(user2);
//		users.add(user3);
//		try {
//			manager.writeAllUsers(users);
//		} catch (TransformerFactoryConfigurationError e) {
//			e.printStackTrace();
//		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//		} catch (TransformerException e) {
//			e.printStackTrace();
//		}
		
//		ManagerXml manager2 = new ManagerXml();
//		try {
//			System.out.println(manager2.parserDocumentToGetUsers());
//		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//		} catch (SAXException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
}