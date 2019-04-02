package com.ps.listmanager.web.service.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.ps.ListManager.service.ListItem;
import com.ps.ListManager.service.UserService;
import com.ps.ListManager.service.implementation.UserServiceImplementation;
import com.ps.ListManager.service.model.User;

//                   SOAP - simple object access protocol 

//Es una especificación XML para transmitir datos. es Ajeno al protocolo de comunicación aprovechado pero comunmente se utiliza http o jms . 
//soap tambien es ampliable , por ejemplo , proporcionando seguridad a través de WS-Security.
//Los servicios web SOAP suelen estar basados en acciones al tener nombre de servicio similares a los nombres de los metodos .
//Debido a que es XML pesado , a menudo es mejor si se combina con herramientas o marcos que simplifican su uso.
//JAX-WS es un ejemplo de un marco que simplifica el uso de SOAP

//IMPORTANTE:
//ANTES DE REALIZAR ESTE WS DEBEMOS CONFIGURAR EL ARCHIVO IBM-WEB-BND.XML , EL WEB.XML AGREGANDO EL Resource-ref en ambos archivos 

//para que JAX-WS reconozca esta clase como un WS solamente necesitamos agregar la anotacion @WebService e indicar el serviceName en la misma
//si no indicamos el serviceName JAX-WS lo habria generado automaticamente y al final del nombre de la clase se agregaria automaticamente la palabra service
//esto ubiera dado como resultado un WS llamado "UserSoapServiceService"
@WebService(serviceName = "USerSoapService")
public class UserSoapService {

	private final UserService userService;

	public UserSoapService() {
		userService = new UserServiceImplementation();
	}

	// metodo del WS para obtener una id de usuairo del nombre del usuario
	@WebMethod // con esta anotacion habilitamos el metodo en JAX-WS
	public Long getUserId(@WebParam(name = "username") String username) {
		User user = userService.authenticateUSer(username);

		if (user != null) {
			return user.getId();

		}
		return null;

	}

	@WebMethod
	public List<ListItem> getUserListItem(@WebParam(name = "userId") Long userId) {
		return userService.getListItems(userId);
	}
}
