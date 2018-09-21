# Algaworks - Curso Desenvolvimento Web com JSF 2

## <a name="indice">Índice</a>

- [Aplicações web com Java](#parte1)  
    1.1. Introdução ao curso de JSF  
	1.2. Introdução ao desenvolvimento web  
	1.3. Containers Java EE  
	1.4. Instalando o Tomcat  
	1.5. Exercícios: instalação do Tomcat  
	1.6. Instalando e configurando o Eclipse  
	1.7. Exercícios: instalação e configuração do Eclipse  
	1.8. Uma aplicação Java web simples  
	1.9. Importando um projeto do Github no Eclipse  
	1.10. Distribuindo aplicações em WAR  
	1.11. Administrando o Apache Tomcat  
	1.12. Exercícios: aplicação web simples com o Eclipse e Tomcat  
- [Desenvolvimento com JavaServer Faces](#parte2)  
    2.1. O que é JSF?  
	2.2. Baixando uma implementação JSF  
	2.3. Codificando o primeiro projeto  
	2.4. O arquivo web.xml  
	2.5. Managed beans  
	2.6. Exercício: primeiro projeto em JSF  
	2.7. Backing beans  
	2.8. Escopos de aplicação e sessão  
	2.9. Outros escopos de managed beans  
	2.10. Exercício: managed beans e seus escopos  
	2.11. Usando navegação implícita  
	2.12. Manipulando eventos de ação  
	2.13. Manipulando eventos de mudança de valor  
	2.14. Exercício: navegação e eventos  
	2.15. Ciclo de vida  
- [Principais componentes](#parte3)  
	3.1. Atributos comuns de componentes  
	3.2. Entradas, saídas de texto e imagens  
	3.3. Menus, caixas de listagem e itens de seleção  
	3.4. Campos de checagem e botões radio  
	3.5. Botões e links  
	3.6. Painéis  
	3.7. Mensagens  
	3.8. Tabelas de dados  
	3.9. Componentes dentro de células  
	3.10. Aplicando estilos em tabelas  
	3.11. Arquivos JavaScript e CSS  
	3.12. Exercícios: usando componentes e aplicando estilos  
	3.13. Projeto do curso: prototipando tela de consulta de lançamento  
	3.14. Projeto do curso: prototipando tela de novo lançamento  
	3.15. Exercícios: prototipando telas do projeto do curso  
- [Conversão e validação](#parte4)  
	4.1. Conversores de números e datas  
	4.2. Customizando mensagens de erro de conversão  
	4.3. Exercício: usando conversores  
	4.4. Usando validadores  
	4.5. Customizando mensagens de erro de validação  
	4.6. Atributo immediate  
	4.7. Exercício: usando validadores  
	4.8. Criando conversores personalizados  
	4.9. Criando validadores personalizados  
	4.10. Exercício: criando conversores e validadores  
	4.11. Projeto do curso: usando conversores e validadores  
	4.12. Projeto do curso: conversor personalizado  
	4.13. Projeto do curso: validador de data futura  
	4.14. Projeto do curso: validador condicional  
	4.15. Exercício: usando conversores e validadores no projeto do curso  
- [Persistência de dados](#parte5)  
	5.1. Preparando um banco de dados  
	5.2. Conhecendo e configurando JPA 2 com Hibernate  
	5.3. Mapeamento objeto-relacional  
	5.4. Testando o Hibernate  
	5.5. Carregando menu de pessoas do banco de dados  
	5.6. Integrando as telas com Hibernate  
	5.7. Exclusão de lançamentos do banco de dados  
	5.8. Transações e o pattern Open Session in View  
	5.9. Pattern Repository  
	5.10. Implementando regras de negócio  
	5.11. Exercício: implementando o pattern repository e a camada de regras de negócio  
- [JavaServer Faces Avançado](#parte6)  
    6.1. Suporte ao método GET  
	6.2. Regras de navegação explícitas  
	6.3. Aplicações JSF com AJAX 22m 26s  
	6.4. Exercício: método GET e AJAX  
	6.5. Template de páginas com Facelets 34m 5s  
- [Colocando em produção](#parte7)  
	7.1. Preparando o ambiente Java em um servidor cloud  
	7.2. Fazendo deploy da aplicação na nuvem  
	7.3. conclusao-e-proximos-passos-v1  

---

## <a name="parte1">Aplicações web com Java</a>

1.8. Uma aplicação Java web simples  

```java
package com.algaworks;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OlaMundo")
public class OlaMundo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Olá MUndo</h1>");
		out.println("Testando o Servlet do curso");
		out.println("</body>");
		out.println("</html>");
	}

}

```

```jsp
<?xml version="1.0" encoding="ISO-8859-1" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=ISO-8859-1" 
		pageEncoding="ISO-8859-1" session="false"/>
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Olá mundo</title>
</head>
<body>
	<h1>Ola mundo</h1>
	<p>teste</p>
</body>
</html>
</jsp:root>
```

[Voltar ao Índice](#indice)

---

## <a name="parte2">Desenvolvimento com JavaServer Faces</a>

#### 2.1-o-que-e-jsf-v1

![mvc](https://github.com/josemalcher/ALGAWORKS-Curso-Desenvolvimento-Web-com-JSF-2/blob/master/readme-img/mvc.png?raw=true)


#### 2.2-baixando-uma-implementacao-jsf-v1

- https://javaserverfaces.github.io/download.html

#### 2.3. Codificando o primeiro projeto

```xhtml
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	  xmlns:h="http://java.sun.com/jsf/html"	>
<h:head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Olá Mundo!!</title>
</h:head>
<h:body>
	<h:inputText value="Digite seu nome aqui!!" />
	<h:commandButton value="Clique Aqui" />	
</h:body>
</html>
```

#### 2.4. O arquivo web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/javaee" xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" version="3.0">
  <display-name>ArquivoWebXML</display-name>
  <context-param>
  	<param-name>javax.faces.PROJECT_STAGE</param-name>
  	<param-value>Development</param-value>
  	<!-- <param-value>Production</param-value> -->
  </context-param>
  <servlet>
    <servlet-name>Faces Servlet</servlet-name>
    <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>Faces Servlet</servlet-name>
    <url-pattern>*.xhtml</url-pattern>
  </servlet-mapping>
</web-app>
```

#### 2.5. Managed beans

```xhtml
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	  xmlns:h="http://java.sun.com/jsf/html"	>
<h:head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Olá Mundo!!</title>
</h:head>
<h:body>
	<h:form>
		Seu nome: <h:inputText value="#{olaMundoBean.nome}"  />
		<h:commandButton value="Enviar" action="#{olaMundoBean.enviar}" />
		<br/>
		Nome Digitado: #{olaMundoBean.nome}
	</h:form>	
</h:body>
</html>
```

```java
package com.algawork.cursojsf2;

import javax.faces.bean.ManagedBean;

@SuppressWarnings("deprecation")
@ManagedBean
public class OlaMundoBean {
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void enviar() {
		this.setNome(this.getNome().toUpperCase());
	}
	
}


```

```xml
<?xml version="1.0" encoding="UTF-8"?>

<faces-config
    xmlns="http://java.sun.com/xml/ns/javaee"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-facesconfig_2_0.xsd"
    version="2.0">
    
    <managed-bean>
    	<managed-bean-name>olaMundoBeans</managed-bean-name>
    	<managed-bean-class>com.algaworks.cursojsf2.OlaMundoBean</managed-bean-class>
    	<managed-bean-scope>request</managed-bean-scope>
    </managed-bean>

</faces-config>

```

[Voltar ao Índice](#indice)

---

## <a name="parte3">Principais componentes</a>

## <a name="parte4">Conversão e validação</a>

[Voltar ao Índice](#indice)

---

## <a name="parte5">Persistência de dados</a>

[Voltar ao Índice](#indice)

---

## <a name="parte6">JavaServer Faces Avançado</a>

[Voltar ao Índice](#indice)

---

## <a name="parte7">Colocando em produção</a>

[Voltar ao Índice](#indice)

---