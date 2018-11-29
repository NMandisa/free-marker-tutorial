package za.co.fynbos.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import za.co.fynbos.freemarker.config.ConfigurationUtil;
import za.co.fynbos.freemarker.first.MailExampleValueObject;
import za.co.fynbos.freemarker.first.ValueExampleObject;

public class MainTest {
	public static void main(String[] args) throws Exception {

        // 1. Configure FreeMarker
        Configuration cfg = ConfigurationUtil.getConfiguration();
       
        // 2. Proccess template(s)
        //
        // You will do this for several times in typical applications.

        // 2.1. Prepare the template input:

        Map<String, Object> input = new HashMap<String, Object>();

        input.put("title", "FreeMarker Tutorial example");

        input.put("exampleObject", new ValueExampleObject("Java object", "me"));
        input.put("mailExampleObject", new MailExampleValueObject("abc@xyz.com","Hello Mail Compaign","We will sell you ..."));

        List<ValueExampleObject> systems = new ArrayList<ValueExampleObject>();
        systems.add(new ValueExampleObject("Android", "Google"));
        systems.add(new ValueExampleObject("iOS States", "Apple"));
        systems.add(new ValueExampleObject("Ubuntu", "Canonical"));
        systems.add(new ValueExampleObject("Windows 10.", "Microsoft"));
        input.put("systems", systems);

        // 2.2. Get the template
        
        Template template = cfg.getTemplate("helloworld.ftl");

        // 2.3. Generate the output

        // Write output to the console
        Writer consoleWriter = new OutputStreamWriter(System.out);
        template.process(input, consoleWriter);

        // For the sake of example, also write output into a file:
        Writer fileWriter = new FileWriter(new File("output.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }

    }
}
