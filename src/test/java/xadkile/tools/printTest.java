package xadkile.tools;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.*;

import static org.junit.Assert.*;

public class printTest {

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    String content = "Content ABC";
    List<TestContent> testContents = new ArrayList<>(Arrays.asList(
        new TestContent("content1"),
        new TestContent("content2"),
        new TestContent("content3"),
        new TestContent("content4"),
        new TestContent("content5")
    ));
    @BeforeEach
    public void beforeAll(){
        print.setWriter(new PrintWriter(output));

    }
    @Test
    public void n() {
        print.n(content);
        assertEquals(content,output.toString());
    }

    @Test
    public void ln(){
        print.ln(content);
        assertEquals(content+System.lineSeparator(),output.toString());
    }

    @Test
    public void f(){
        print.f("%s",content);
        assertEquals(content,output.toString());
    }

    @Test
    public void fln(){
        print.fln("%s",content);
        assertEquals(content+System.lineSeparator(),output.toString());
    }

    @Test
    public void list(){
        List<TestContent> testContents = new ArrayList<>(Arrays.asList(
            new TestContent("content1"),
            new TestContent("content2"),
            new TestContent("content3"),
            new TestContent("content4"),
            new TestContent("content5")
        ));
        print.list(testContents);
        StringBuilder builder = new StringBuilder();
        for (TestContent testContent : testContents) {
            builder.append(testContent.toString()+System.lineSeparator());
        }

        assertEquals(builder.toString(),output.toString());
    }

    @Test
    public void map(){
        Map<TestContent,TestContent> mapContent = new LinkedHashMap<>();
        mapContent.put(new TestContent("k1"),new TestContent("v1"));
        mapContent.put(new TestContent("k2"),new TestContent("v2"));

        StringBuilder expect = new StringBuilder();
        for (Map.Entry<TestContent, TestContent> entry : mapContent.entrySet()) {
            expect.append(String.format("%s : %s%s",
                entry.getKey().toString(),
                entry.getValue().toString(),
                System.lineSeparator()));
        }

        print.map(mapContent);
        assertEquals(expect.toString(),output.toString());
    }

    @Test
    public void listIndex(){
        print.listIndex(testContents);
        StringBuilder expect = new StringBuilder();
        int x=0;
        for (TestContent tc : testContents) {
            expect.append(String.format("%s: %s%s",x,tc.toString(),System.lineSeparator()));
            ++x;
        }
        assertEquals(expect.toString(),output.toString());
    }
}