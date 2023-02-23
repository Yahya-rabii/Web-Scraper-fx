package com.example.webscraperfx;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WebScraper {

    public void scrapeWebsite(String url) {
        Document doc;
        try {
            // Connect to the URL and set a user agent to avoid being blocked as a bot.
            doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
                    .get();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Select all the elements on the page with the class "c-prd".
        Elements products = doc.select(".c-prd");

        // If there are no products, print a message and return.
        if (products.size() == 0) {
            System.out.println("No products found on the page.");
            return;
        }

        // Create a new file for the output and write the product information to it.
        File outputFile = new File("output.txt");

        try {
            FileWriter writer = new FileWriter(outputFile);
            for (Element product : products) {
                // Select the name, price, and promotion elements for each product.
                String name = product.select(".name").text();
                String price = product.select(".prc").text();
                String promotion  = product.select(".old").text();

                // Write the product information to the output file.
                writer.write("Price: " + price + "\tName: " + name + "\tprix original: " + promotion  + "\n\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Print a message to indicate that the website has been scraped and the output has been saved.
        System.out.println("The website has been scraped and saved to " + outputFile.getAbsolutePath());
    }
}
