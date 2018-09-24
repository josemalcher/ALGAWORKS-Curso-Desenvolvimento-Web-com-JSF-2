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

#### 2.7. Backing beans

```java
package com.algaworlks.cursosjsf2;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;

@ManagedBean
public class TesteBean {
	private HtmlInputText campo;
	private HtmlCommandButton botao;
	public HtmlInputText getCampo() {
		return campo;
	}
	public void setCampo(HtmlInputText campo) {
		this.campo = campo;
	}
	public HtmlCommandButton getBotao() {
		return botao;
	}
	public void setBotao(HtmlCommandButton botao) {
		this.botao = botao;
	}
	
	public void testar() {
		if(this.campo.isDisabled()) {
			this.campo.setDisabled(false);
			this.botao.setStyle("");
		}else {
			this.campo.setDisabled(true);
			this.botao.setStyle("background-color: red; color: white");	
		}
		
	}
}

```

```html
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	  xmlns:h="http://java.sun.com/jsf/html"	>
<h:head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Testes!!</title>
</h:head>
<h:body>
	<h:form>
		Seu nome: <h:inputText binding="#{testeBean.campo}"  />
		<h:commandButton value="Enviar" binding="#{testeBean.botao}" action="#{testeBean.testar}" />
		<br/>
		
	</h:form>	
</h:body>
</html>
```

#### 2.8. Escopos de aplicação e sessão

```java
package com.cursojsf2.dominio;

public class Produto {
	private String nome;
	private String fabricante;
	private String categoria;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}

```

```java
package com.cursojsf2.visao;

import java.util.ArrayList;
import java.util.List;

//import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.cursojsf2.dominio.Produto;
@ManagedBean
//@ApplicationScoped
@SessionScoped
public class GestaoProdutoBean{
	
	private List<Produto> produtos;
	private Produto produto;
	
	public GestaoProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto  = new Produto();
	}

	public void incluir() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	
	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
}

```

```xhtml
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	  xmlns:h="http://java.sun.com/jsf/html"
	  xmlns:ui="http://java.sun.com/jsf/facelets"	>
<h:head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Gestão de Produtos</title>
</h:head>
<h:body>
	<h:form>
		Nome: <h:inputText value="#{gestaoProdutoBean.produto.nome}" />
		<br/>
		Fabricante<h:inputText value="#{gestaoProdutoBean.produto.fabricante}" />
		<br/>
		Categoria<h:inputText value="#{gestaoProdutoBean.produto.categoria}" />
		<h:commandButton value="Incluir" action="#{gestaoProdutoBean.incluir}" />
		<br/>
		
	</h:form>	
	
	<ol>
		<ui:repeat var="item" value="#{gestaoProdutoBean.produtos}">
			<li>#{item.nome}   -   #{item.fabricante}   -  #{item.categoria}</li>
		</ui:repeat>
	</ol>
</h:body>
</html>
```

#### 2.9-outros-escopos-de-managed-beans-v1

```java
package com.cursojsf2.dominio;

import java.io.Serializable;

public class Produto implements Serializable {
	private String nome;
	private String fabricante;
	private String categoria;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}

```

```java
package com.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.cursojsf2.dominio.Produto;

@ManagedBean
//@ViewScoped
@RequestScoped //padrão
//@NoneScoped
public class GestaoProdutoBean implements Serializable {
	private List<Produto> produtos;
	private Produto produto;
	
	public GestaoProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public void incluir() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Produto getProduto() {
		return produto;
	}
	
	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializou o Bean");
	}
	
	@PreDestroy
	public void finalizar() {
		System.out.println("Finalizou o Bean");
	}
}

```

```xhtml
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	  xmlns:h="http://java.sun.com/jsf/html"
	  xmlns:ui="http://java.sun.com/jsf/facelets"	>
<h:head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Gestão de Produtos</title>
</h:head>
<h:body>
	<h:form>
		Nome: <h:inputText value="#{gestaoProdutoBean.produto.nome}" />
		<br/>
		Fabricante<h:inputText value="#{gestaoProdutoBean.produto.fabricante}" />
		<br/>
		Categoria<h:inputText value="#{gestaoProdutoBean.produto.categoria}" />
		<h:commandButton value="Incluir" action="#{gestaoProdutoBean.incluir}" />
		<br/>
		
	</h:form>	
	
	<ol>
		<ui:repeat var="item" value="#{gestaoProdutoBean.produtos}">
			<li>#{item.nome}   -   #{item.fabricante}   -  #{item.categoria}</li>
		</ui:repeat>
	</ol>
</h:body>
</html>

```

#### 2.11-usando-navegacao-implicita-v1

```
<h:commandLink value="Ajuda sobre esta Tela" action="#{gestaoProdutoBean.obterAjuda}"/>
```

```java
	
	public String obterAjuda() {
		if(this.produtos.isEmpty()) {
			return "AjudaGestaoProdto?faces-redirect=true";
		}else {
			return "AjudaGestaoProdtoTelefone?faces-redirect=true";
		}
	}
	
```

#### 2.12-manipulando-eventos-de-acao-v1

```xhtml
<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	  xmlns:h="http://java.sun.com/jsf/html"
	  xmlns:ui="http://java.sun.com/jsf/facelets"
	  xmlns:f="http://java.sun.com/jsf/core"	>
<h:head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Gestão de Produtos</title>
</h:head>
<h:body>
	<h:form>
		<h:commandLink value="Ajuda sobre esta Tela" action="#{gestaoProdutoBean.obterAjuda}">
			 <f:actionListener binding="#{registroCliqueBotaoListener}"/>
			 <!-- <f:actionListener type="com.cursojsf2.visao.registroCliqueBotaoListener"/> --> 
		</h:commandLink>
		<br/><br/>
		
		
		Nome: <h:inputText value="#{gestaoProdutoBean.produto.nome}" />
		<br/>
		Fabricante<h:inputText value="#{gestaoProdutoBean.produto.fabricante}" />
		<br/>
		Categoria<h:inputText value="#{gestaoProdutoBean.produto.categoria}" />
		<h:commandButton value="Incluir" action="#{gestaoProdutoBean.incluir}"  
										 actionListener="#{gestaoProdutoBean.verificarInclusao}">
			<f:actionListener binding="#{registroCliqueBotaoListener}"/>
		</h:commandButton>
		
		<br/>
		
	</h:form>	
	
	<h:form>
	<ol>
		<ui:repeat var="item" value="#{gestaoProdutoBean.produtos}">
			<li>
			#{item.nome}   -   #{item.fabricante}   -  #{item.categoria}
			<h:commandButton value="Excluir" action="#{gestaoProdutoBean.excluir}">
				<f:setPropertyActionListener value="#{item}" target="#{gestaoProdutoBean.produtoSelecionado}" />
			</h:commandButton>
			</li>
		</ui:repeat>
	</ol>
	</h:form>
</h:body>
</html>
```

```java
package com.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.cursojsf2.dominio.Produto;


@ManagedBean
@SessionScoped
public class GestaoProdutoBean implements Serializable {
	private List<Produto> produtos;
	private Produto produto;
	
	private Produto produtoSelecionado;
	
	public GestaoProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public void incluir() {
		System.out.println("Incluindo!");
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Produto getProduto() {
		return produto;
	}
	
	
	
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializou o Bean");
	}
	
	@PreDestroy
	public void finalizar() {
		System.out.println("Finalizou o Bean");
	}
	
	public String obterAjuda() {
		if(this.produtos.isEmpty()) {
			return "AjudaGestaoProdto?faces-redirect=true";
		}else {
			return "AjudaGestaoProdtoTelefone?faces-redirect=true";
		}
	}
	
	public void verificarInclusao(ActionEvent event) {
		System.out.println("Verificando....");
		if("".equals(this.produto.getFabricante())) {
			this.produto.setFabricante("Sem Fabricante");
		}
	}
	
	public void excluir() {
		this.produtos.remove(this.produtoSelecionado);
	}
	
	
	
}

```

```java
package com.cursojsf2.visao;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

@ManagedBean
public class RegistroCliqueBotaoListener implements ActionListener{

	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		System.out.println("Clicando no botão " + event.getComponent().getId());
		
	}
	
}

```

#### 2.13-manipulando-eventos-de-mudanca-de-valor-v1

```java
package com.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import com.cursojsf2.dominio.Produto;


@ManagedBean
@SessionScoped
public class GestaoProdutoBean implements Serializable {

	private String nomePesquisa;
	private List<Produto> produtos;
	private List<Produto> produtosFiltrados;
	private Produto produto;
	
	private Produto produtoSelecionado;

	public GestaoProdutoBean() {
		this.produtos = new ArrayList<Produto>();
		this.produtosFiltrados = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public void nomePesquisaAlterado(ValueChangeEvent event) {
		System.out.println("Valor atual: " + this.nomePesquisa);
		System.out.println("Novo valor: " + event.getNewValue());
		
		this.produtosFiltrados.clear();
		
		for (Produto produto : this.produtos) {
			if (produto.getNome() != null && produto.getNome().toLowerCase()
					.startsWith(event.getNewValue().toString().toLowerCase())) {
				this.produtosFiltrados.add(produto);
			}
		}
	}
	
	public void incluir() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	
	public void excluir() {
		this.produtos.remove(this.produtoSelecionado);
	}
	
	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}

	public String getNomePesquisa() {
		return nomePesquisa;
	}

	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}

	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}
}

```

```xhtml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:f="http://java.sun.com/jsf/core">
	<h:head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Gestão de Produtos</title>
	</h:head>
	<h:body>
		<h:form>
			Nome:
			<h:inputText value="#{gestaoProdutoBean.produto.nome}" />
			<br/>
			
			Fabricante:
			<h:inputText value="#{gestaoProdutoBean.produto.fabricante}" />
			<br/>
			
			Categoria:
			<h:inputText value="#{gestaoProdutoBean.produto.categoria}" />
			<br/>
			
			<h:commandButton value="Incluir" action="#{gestaoProdutoBean.incluir}"/>
		</h:form>

		<br/>
		<h:form>
			Pesquisa por nome:
			<h:inputText value="#{gestaoProdutoBean.nomePesquisa}" 
				valueChangeListener="#{gestaoProdutoBean.nomePesquisaAlterado}"	onchange="submit()"/>
		</h:form>

		<h:form>
			<ol>
				<ui:repeat var="item" value="#{gestaoProdutoBean.produtosFiltrados}">
					<li>
						#{item.nome} - #{item.fabricante} - #{item.categoria}
						<h:commandButton value="Excluir" action="#{gestaoProdutoBean.excluir}">
							<f:setPropertyActionListener target="#{gestaoProdutoBean.produtoSelecionado}" value="#{item}" />
						</h:commandButton>
					</li>
				</ui:repeat>
			</ol>
		</h:form>
	</h:body>
</html>
```


#### 2.15-ciclo-de-vida-v1

![Primeira Requisição](https://github.com/josemalcher/ALGAWORKS-Curso-Desenvolvimento-Web-com-JSF-2/blob/master/readme-img/primeira_requisicao.png?raw=true)

![postback](https://github.com/josemalcher/ALGAWORKS-Curso-Desenvolvimento-Web-com-JSF-2/blob/master/readme-img/postback.png?raw=true)

[Voltar ao Índice](#indice)

---

## <a name="parte3">Principais componentes</a>

#### 3.1-atributos-comuns-de-componentes-v1

```xhtml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:f="http://java.sun.com/jsf/core">
	<h:head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Atributos Comuns</title>
		
		<style>
			.campo {
				background-color: #c0c0c0;
				padding: 4px
			}
			
			.campo:focus {
				background-color: yellow;
			}
		</style>
		
		<script>
			function validar() {
				campoEmail = document.getElementById('newsletterForm:email');
				
				if (campoEmail.value == '') {
					alert('Informe seu e-mail!');
					return false;
				}
				alert('e-mail... ok!');
				return true;
			}
		</script>
	</h:head>
	<h:body>
		<h:form id="newsletterForm">
			<h:outputLabel value="Assine nossa newsletter" rendered="true" />
			<br/>
			
			<h:inputText value="Seu e-mail aqui" 
				size="40" maxlength="30" 
				title="Informe seu e-mail aqui"
				onfocus="this.value = ''" 
				id="email" 
				style="font-size: 19px" styleClass="campo" />
				
			<h:commandButton value="Assinar" 
				onclick="return validar()" 
				id="assinarBotao" />
		</h:form>
	</h:body>
</html>
```

#### 3.2-entradas-saidas-de-texto-e-imagens-v1

```java
package com.cursojsf2;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CadastroCVBean {
	private String vaga = "A0382D";
	private String cargo = "Programador Java Senior";
	
	public String getVaga() {
		return vaga;
	}
	public void setVaga(String vaga) {
		this.vaga = vaga;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}

```

```xhtml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:f="http://java.sun.com/jsf/core">
	<h:head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Entrada e Saída de textos e imagens</title>
	</h:head>
	<h:body>
		<h:form>
			<h:graphicImage value="/img/algaworks.png" />
			<br/>
		
			<h:outputText value="Cadastro de currículo para vaga #{cadastroCVBean.vaga}" 
				style="font-weight: bold; font-size: 22px" />
			<br/>
			
			<h:outputFormat value="Vaga {0} - Cargo {1}" style="color: red">
				<f:param value="#{cadastroCVBean.vaga}"/>
				<f:param value="#{cadastroCVBean.cargo}"/>
			</h:outputFormat>
			
			<br/><br/>
			
			<h:outputLabel value="E-mail" for="email"/><br/>
			<h:inputText size="60" id="email" />
			<br/>
			
			<h:outputLabel value="Senha"/><br/>
			<h:inputSecret size="40"/>
			<br/>
			
			<h:outputLabel value="Qualificações"/><br/>
			<h:inputTextarea cols="60" rows="5" />
			<br/>
				
			<h:commandButton value="Cadastrar" />
		</h:form>
	</h:body>
</html>
```


#### 3.3-menus-caixas-de-listagem-e-itens-de-selecao-v1

#### 3.4-campos-de-checagem-e-botoes-radio-v1

#### 3.5-botoes-e-links-v1

#### 3.6-paineis-v1

#### 3.7-mensagens-v1

#### 3.8-tabelas-de-dados-v1

#### 3.9-componentes-dentro-de-celulas-v1

#### 3.10-aplicando-estilos-em-tabelas-v1

#### 3.11-arquivos-javascript-e-css-v1

#### 3.13-projeto-do-curso-protitipando-tela-de-consulta-de-lanca

#### 3.14-projeto-do-curso-prototipando-tela-de-novo-lancamento-v

[Voltar ao Índice](#indice)

---


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