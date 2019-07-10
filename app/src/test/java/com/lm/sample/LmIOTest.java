package com.lm.sample;

import com.lm.io.InputStreamWrapper;
import com.lm.io.LmIO;
import com.lm.io.OutputStreamWrapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * LmIO 测试
 */
public class LmIOTest {

    private File file;

    @Before
    public void init() {
        file = new File("test_io.txt");
        System.out.println("=================================================");
        System.out.println("@Before create file ==> " + file.getAbsoluteFile());
    }

    @After
    public void destroy() {
//        boolean isDelete = file.delete();
//        System.out.println("@After delete file ==> " + isDelete);
    }

    @Test
    public void testUTF8Line1() {
        System.out.println("@Test ==> testUTF8Line1");
        try {
            String content = "aaaaaaaa";
            LmIO.outputStreamWrapper(file, false).writeUTF8(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            String read = inputStreamWrapper.readUTF8Line();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content.equals(read));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUTF8Line2() {
        System.out.println("@Test ==> testUTF8Line2");
        try {
            String content = "aaaaaaaa\n";
            LmIO.outputStreamWrapper(file, false).writeUTF8(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            String read = inputStreamWrapper.readUTF8Line();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content.replace("\n", "").equals(read));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUTF8Line3() {
        System.out.println("@Test ==> testUTF8Line3");
        try {
            String content = "aaaaaaaa\r\n";
            LmIO.outputStreamWrapper(file, false).writeUTF8(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            String read = inputStreamWrapper.readUTF8Line();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content.replace("\r\n", "").equals(read));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testByte1() {
        System.out.println("@Test ==> testByte1");
        try {
            byte content = 65;
            LmIO.outputStreamWrapper(file, false).writeByte(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            byte read = inputStreamWrapper.readByte();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content == read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testByte2() {
        System.out.println("@Test ==> testByte2");
        try {
            byte content = Byte.MAX_VALUE;
            LmIO.outputStreamWrapper(file, false).writeByte(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            byte read = inputStreamWrapper.readByte();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content == read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testByte3() {
        System.out.println("@Test ==> testByte3");
        try {
            byte content = Byte.MIN_VALUE;
            LmIO.outputStreamWrapper(file, false).writeByte(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            byte read = inputStreamWrapper.readByte();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content == read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testShort1() {
        System.out.println("@Test ==> testShort1");
        try {
            short content = 65;
            LmIO.outputStreamWrapper(file, false).writeShort(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            short read = inputStreamWrapper.readShort();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content == read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testShort2() {
        System.out.println("@Test ==> testShort2");
        try {
            short content = Short.MAX_VALUE;
            LmIO.outputStreamWrapper(file, false).writeShort(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            short read = inputStreamWrapper.readShort();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content == read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testShort3() {
        System.out.println("@Test ==> testShort3");
        try {
            short content = Short.MIN_VALUE;
            LmIO.outputStreamWrapper(file, false).writeShort(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            short read = inputStreamWrapper.readShort();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content == read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInt1() {
        System.out.println("@Test ==> testInt1");
        try {
            int content = 65;
            LmIO.outputStreamWrapper(file, false).writeInt(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            int read = inputStreamWrapper.readInt();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content == read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInt2() {
        System.out.println("@Test ==> testInt2");
        try {
            int content = Integer.MIN_VALUE;
            LmIO.outputStreamWrapper(file, false).writeInt(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            int read = inputStreamWrapper.readInt();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content == read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInt3() {
        System.out.println("@Test ==> testInt3");
        try {
            int content = Integer.MIN_VALUE;
            LmIO.outputStreamWrapper(file, false).writeInt(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            int read = inputStreamWrapper.readInt();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content == read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLong1() {
        System.out.println("@Test ==> testLong1");
        try {
            long content = 65;
            LmIO.outputStreamWrapper(file, false).writeLong(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            long read = inputStreamWrapper.readLong();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content == read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLong2() {
        System.out.println("@Test ==> testLong2");
        try {
            long content = Long.MAX_VALUE;
            LmIO.outputStreamWrapper(file, false).writeLong(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            long read = inputStreamWrapper.readLong();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content == read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testLong3() {
        System.out.println("@Test ==> testLong3");
        try {
            long content = Long.MIN_VALUE;
            LmIO.outputStreamWrapper(file, false).writeLong(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            long read = inputStreamWrapper.readLong();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content == read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadAll() {
        System.out.println("@Test ==> testReadAll");
        try {
            String content = "aaaaaaaa\nbbbbbb\ncccccc\n";
            LmIO.outputStreamWrapper(file, false).writeUTF8(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            String read = inputStreamWrapper.readAllUTF8();
            System.out.println("read  ==> |" + read + "|");
            inputStreamWrapper.close();
            assertTrue(content.equals(read));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStringAppend() {
        System.out.println("@Test ==> testStringAppend");
        try {
            String content = "aaaaaaaa\n";
            LmIO.outputStreamWrapper(file, false).writeUTF8(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            LmIO.outputStreamWrapper(file, true).writeUTF8(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            String read = inputStreamWrapper.readUTF8Line();
            System.out.println("read  ==> |" + read + "|");
            assertTrue(content.replace("\n", "").equals(read));
            read = inputStreamWrapper.readUTF8Line();
            System.out.println("read  ==> |" + read + "|");
            assertTrue(content.replace("\n", "").equals(read));
            inputStreamWrapper.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUTF8_1() {
        String url = "http://192.168.1.105:8085/repository/maven-snapshots/";
        String userName = "admin";
        String password = "admin123";
        String groupId = "com.ybzg";
        String artifactId = "utils";
        String version = "1.0.5-SNAPSHOT";
        String packaging = "aar";
        String description = "工具类";
        String content = new StringBuilder()
                .append("def nexus_maven = [:]\n")
                .append("nexus_maven.url = \"").append(url).append("\"\n")
                .append("nexus_maven.userName = \"").append(userName).append("\"\n")
                .append("nexus_maven.password = \"").append(password).append("\"\n")
                .append("nexus_maven.groupId = \"").append(groupId).append("\"\n")
                .append("nexus_maven.artifactId = \"").append(artifactId).append("\"\n")
                .append("nexus_maven.version = \"").append(version).append("\"\n")
                .append("nexus_maven.packaging = \"").append(packaging).append("\"\n")
                .append("nexus_maven.description = \"").append(description).append("\"\n")
                .append("\n")
                .append("apply plugin: 'maven'\n")
                .append("\n")
                .append("task androidJavadocs(type: Javadoc) {\n")
                .append("    options.encoding = \"UTF-8\"\n")
                .append("    source = android.sourceSets.main.java.srcDirs\n")
                .append("    classpath += project.files(android.getBootClasspath().join(File.pathSeparator))\n")
                .append("}\n")
                .append("\n")
                .append("task androidJavadocsJar(type: Jar, dependsOn: androidJavadocs) {\n")
                .append("    classifier = 'javadoc'\n")
                .append("    from androidJavadocs.destinationDir\n")
                .append("}\n")
                .append("\n")
                .append("task androidSourcesJar(type: Jar) {\n")
                .append("    classifier = 'sources'\n")
                .append("    from android.sourceSets.main.java.srcDirs\n")
                .append("}\n")
                .append("\n")
                .append("artifacts {\n")
                .append("    archives androidSourcesJar\n")
                .append("    archives androidJavadocsJar\n")
                .append("}\n")
                .append("\n")
                .append("uploadArchives {\n")
                .append("    repositories {\n")
                .append("        mavenDeployer {\n")
                .append("            repository(url: \"$nexus_maven.url\") {\n")
                .append("                authentication(userName: \"$nexus_maven.userName\", password: \"$nexus_maven.password\")\n")
                .append("            }\n")
                .append("            pom.project {\n")
                .append("                groupId \"$nexus_maven.groupId\"\n")
                .append("                artifactId \"$nexus_maven.artifactId\"\n")
                .append("                version \"$nexus_maven.version\"\n")
                .append("                packaging \"$nexus_maven.packaging\"\n")
                .append("                description \"$nexus_maven.description\"\n")
                .append("            }\n")
                .append("        }\n")
                .append("    }\n")
                .append("}")
                .toString();
        try {
            LmIO.outputStreamWrapper(file, false).writeUTF8(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            String read = inputStreamWrapper.readAllUTF8();
            System.out.println("read  ==> |" + read + "|");
            assertTrue(content.equals(read));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUTF8_2() {
        String url = "http://192.168.1.105:8085/repository/maven-snapshots/";
        String userName = "admin";
        String password = "admin123";
        String groupId = "com.ybzg";
        String artifactId = "utils";
        String version = "1.0.5-SNAPSHOT";
        String packaging = "aar";
        String description = "工具类";
        String content = new StringBuilder()
                .append("def nexus_maven = [:]\n")
                .append("nexus_maven.url = \"").append(url).append("\"\n")
                .append("nexus_maven.userName = \"").append(userName).append("\"\n")
                .append("nexus_maven.password = \"").append(password).append("\"\n")
                .append("nexus_maven.groupId = \"").append(groupId).append("\"\n")
                .append("nexus_maven.artifactId = \"").append(artifactId).append("\"\n")
                .append("nexus_maven.version = \"").append(version).append("\"\n")
                .append("nexus_maven.packaging = \"").append(packaging).append("\"\n")
                .append("nexus_maven.description = \"").append(description).append("\"\n")
                .append("\n")
                .append("apply plugin: 'maven'\n")
                .append("\n")
                .append("task androidJavadocs(type: Javadoc) {\n")
                .append("    options.encoding = \"UTF-8\"\n")
                .append("    source = android.sourceSets.main.java.srcDirs\n")
                .append("    classpath += project.files(android.getBootClasspath().join(File.pathSeparator))\n")
                .append("}\n")
                .append("\n")
                .append("task androidJavadocsJar(type: Jar, dependsOn: androidJavadocs) {\n")
                .append("    classifier = 'javadoc'\n")
                .append("    from androidJavadocs.destinationDir\n")
                .append("}\n")
                .append("\n")
                .append("task androidSourcesJar(type: Jar) {\n")
                .append("    classifier = 'sources'\n")
                .append("    from android.sourceSets.main.java.srcDirs\n")
                .append("}\n")
                .append("\n")
                .append("artifacts {\n")
                .append("    archives androidSourcesJar\n")
                .append("    archives androidJavadocsJar\n")
                .append("}\n")
                .append("\n")
                .append("uploadArchives {\n")
                .append("    repositories {\n")
                .append("        mavenDeployer {\n")
                .append("            repository(url: \"$nexus_maven.url\") {\n")
                .append("                authentication(userName: \"$nexus_maven.userName\", password: \"$nexus_maven.password\")\n")
                .append("            }\n")
                .append("            pom.project {\n")
                .append("                groupId \"$nexus_maven.groupId\"\n")
                .append("                artifactId \"$nexus_maven.artifactId\"\n")
                .append("                version \"$nexus_maven.version\"\n")
                .append("                packaging \"$nexus_maven.packaging\"\n")
                .append("                description \"$nexus_maven.description\"\n")
                .append("            }\n")
                .append("        }\n")
                .append("    }\n")
                .append("}\n")
                .toString();
        try {
            LmIO.outputStreamWrapper(file, false).writeUTF8(content).flush().close();
            System.out.println("write ==> |" + content + "|");
            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            String read;
            StringBuilder result = new StringBuilder();
            while ((read = inputStreamWrapper.readUTF8Line()) != null) {
                System.out.println("read  ==> |" + read + "|");
                result.append(read).append("\n");
            }
            assertTrue(content.equals(result.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUTF8_3() {
        String[] contentSpilt = {"AAAA", "BB", "CCCC", "DDDDDD"};
        String content = "";
        for (int i = 0; i < contentSpilt.length; i++) {
            content = content + contentSpilt[i];
        }

        try {
            OutputStreamWrapper outputStreamWrapper = LmIO.outputStreamWrapper(file, false);
            for (int i = 0; i < contentSpilt.length; i++) {
                outputStreamWrapper.writeUTF8(contentSpilt[i]);
                System.out.println("write ==> |" + contentSpilt[i] + "|");
            }
            outputStreamWrapper.flush();
            outputStreamWrapper.close();

            InputStreamWrapper inputStreamWrapper = LmIO.inputStreamWrapper(file);
            String read = inputStreamWrapper.readAllUTF8();
            System.out.println("read  ==> |" + read + "|");

            assertTrue(content.equals(read));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testByte2Short() {
        short content = Short.MIN_VALUE;

        while (true) {
            byte[] bLE = LmIO.short2BytesLE(content);
            System.out.println("start testByte2Short ==> content=" + content);
            System.out.println(LmIO.bytes2HexString(bLE));
            short sLE = LmIO.bytes2ShortLE(bLE);
            System.out.println(sLE);
            assertTrue(content == sLE);

            byte[] b = LmIO.short2Bytes(content);
            System.out.println(LmIO.bytes2HexString(b));
            short s = LmIO.bytes2Short(b);
            System.out.println(s);
            assertTrue(content == s);
            System.out.println("end testByte2Short ==> content=" + content);

            if (content == Short.MAX_VALUE) break;
            content++;
        }
    }

    @Test
    public void testByte2Int() {
        int start = Short.MAX_VALUE;
        int end = Short.MAX_VALUE + start;

        int content = start;
        while (true) {
            byte[] bLE = LmIO.int2BytesLE(content);
            System.out.println(LmIO.bytes2HexString(bLE));
            int iLE = LmIO.bytes2IntLE(bLE);
            System.out.println(iLE);
            assertTrue(content == iLE);

            byte[] b = LmIO.int2Bytes(content);
            System.out.println(LmIO.bytes2HexString(b));
            int i = LmIO.bytes2Int(b);
            System.out.println(i);
            assertTrue(content == i);

            if (content == end) break;
            content++;
        }
    }

    @Test
    public void testByte2Long() {
        long start = Long.MAX_VALUE-1000;
        long end = start+1000;

        long content = start;
        while (true) {
            System.out.println("testByte2Long ==> content="+content);
            byte[] bLE = LmIO.long2BytesLE(content);
            System.out.println(LmIO.bytes2HexString(bLE));
            long lLE = LmIO.bytes2LongLE(bLE);
            System.out.println(lLE);
            assertTrue(content == lLE);

            byte[] b = LmIO.long2Bytes(content);
            System.out.println(LmIO.bytes2HexString(b));
            long l = LmIO.bytes2Long(b);
            System.out.println(l);
            assertTrue(content == l);

            if (content == end) break;
            content++;
        }
    }
}