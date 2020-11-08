package businessLogic;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import gui.MainGUI;

public class BLFactory {
	public BLFacade getBusinessLogicFactory(int isLocal) {
		ConfigXML c=ConfigXML.getInstance();
		BLFacade appFacadeInterface;
		try {
			if (isLocal == 1) {
				//In this option, you can parameterize the DataAccess (e.g. a Mock DataAccess object)
				DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
				appFacadeInterface=new BLFacadeImplementation(da);
			}else { //If remote
				String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";
				URL url = new URL(serviceName);
				//1st argument refers to wsdl document above
				//2nd argument is service name, refer to wsdl document above
				QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");
				Service service = Service.create(url, qname);
				appFacadeInterface = service.getPort(BLFacade.class);
			} 
			return appFacadeInterface;
		}catch (Exception e) {
			System.out.println("Error in ApplicationLauncher: "+e.toString());
			return null;
		}
	}
}
