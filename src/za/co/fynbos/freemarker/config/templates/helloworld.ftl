<#import "lib/utils.ftl" as u>

<@u.page>
  <p>${exampleObject.name} by ${exampleObject.developer}</p>

  <ul>
    <#list systems as system>
      <li>${system_index + 1}. ${system.name} from ${system.developer}</li>
    </#list>
  </ul>

  <#-- Just another example of using a macro: -->
  <@u.otherExample p1=11 p2=22 />
  
  <#-- Variables -->
  <#-- You can define and assign content to variables inside the FTL files for easy reuse. -->

 <#assign var_link = "http://www.helloworld.com">
	<a href="${var_link}">Click Me I am a Link</a>
	
	<#-- Handling null/undefined values -->
	<#-- FreeMarker requires you to provide an explicit default for variables, so avoid values that are null or undefined: -->
	<!-- Acts like if the color was N/A if there's no color: -->
	<p>Color: ${color!'No Color Defined'}</p>

	<!-- Avoid the whole color row if there's no color: -->
	<#if color??>
  	<p>Color: ${color}</p>
	</#if>
	
	<#-- Escape -->
	<#-- When generating HTML,
	 it’s important to escape <, &, etc. in values that were not meant to store HTML and can contain these problematic characters.
	 You can apply such escaping like ${message?html}. You can also ask FreeMarker to add ?html to all ${} -s in a section like this: -->
	<#escape x as x?html>
  <p>Sender: ${mailExampleObject.from}
  <p>Title: ${mailExampleObject.title}
  <p>Message: ${mailExampleObject.body}
</#escape>
	
</@u.page>