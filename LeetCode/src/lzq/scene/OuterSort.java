package lzq.scene;

import java.io.*;
import java.util.*;

public class OuterSort {
    private static final int FILE_SIZE = 16;
    private static final String SPLIT_FILE_PARENT = "/Users/luzheqi/workspace/test/spilt";
    private static final String REORDER_FILE_PARENT = "/Users/luzheqi/workspace/test/reorder";
    private static final String RESULT_FILE_PARENT = "/Users/luzheqi/workspace/test/result";

    public List<String> spiltFile(String filePath) throws IOException {
        File splitParentFile = new File(SPLIT_FILE_PARENT);
        List<BufferedWriter> spiltFiles = new ArrayList<>();
        List<String> spiltFileNames = new ArrayList<>();
        BufferedReader rawFile = new BufferedReader(new FileReader(filePath));

        if (!splitParentFile.exists()) {
            splitParentFile.mkdirs();
        }

        for (int i = 0; i < FILE_SIZE; i++) {
            String fileName = SPLIT_FILE_PARENT + "/" + i;
            spiltFileNames.add(fileName);
            BufferedWriter split = new BufferedWriter(new FileWriter(fileName));
            spiltFiles.add(split);

        }
        int i = 0;
        String str = "";
        while ((str = rawFile.readLine()) != null) {
            spiltFiles.get(i).write(str);
            spiltFiles.get(i).write("\n");
            i = (i + 1) % FILE_SIZE;
        }
        rawFile.close();
        spiltFiles.forEach(t -> {
            try {
                t.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return spiltFileNames;
    }

    public List<String> reorderEachFile(List<String> unorderedFiles) throws IOException {
        File reorderFileParentPath = new File(REORDER_FILE_PARENT);
        if (!reorderFileParentPath.exists()) {
            reorderFileParentPath.mkdirs();
        }

        List<String> reorderFiles = new ArrayList<>();
        int i = 0;
        for(String file : unorderedFiles) {
            BufferedReader oFile = new BufferedReader(new FileReader(file));
            List<Integer> numbers = new ArrayList<>();
            String str = "";
            while((str = oFile.readLine()) != null) {
                if(!str.equals("")) {
                    numbers.add(Integer.parseInt(str));
                }
            }
            Collections.sort(numbers);
            String orderFileName = REORDER_FILE_PARENT + "/" + i++;
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(orderFileName));
            for(int number: numbers){
                bufferedWriter.write(String.valueOf(number));
                bufferedWriter.write("\n");
            }
            bufferedWriter.close();
            oFile.close();
            reorderFiles.add(orderFileName);
        }
        return reorderFiles;
    }

    public String order(List<String> subFiles) throws IOException {
        File resultFileParentPath = new File(RESULT_FILE_PARENT);
        if (!resultFileParentPath.exists()) {
            resultFileParentPath.mkdirs();
        }
        String resultFile = RESULT_FILE_PARENT + "/0";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultFile));
        PriorityQueue<CurrentNode> q = new PriorityQueue<>((o1, o2) -> Integer.parseInt(o1.getCurr()) - Integer.parseInt(o2.getCurr()));
        for(String sub: subFiles){
            BufferedReader b = new BufferedReader(new FileReader(sub));
            String str = b.readLine();
            if(str != null && !str.equals("")){
                q.add(new CurrentNode(str, b));
            }
        }
        while(!q.isEmpty()){
            CurrentNode node = q.poll();
            bufferedWriter.write(node.curr);
            bufferedWriter.write("\n");
            node.read();
            if(null != node.getCurr() && !node.getCurr().equals("")){
                q.add(node);
            }else{
                node.close();
            }
        }
        bufferedWriter.close();
        return resultFile;
    }

    static class CurrentNode {
        private String curr;
        private BufferedReader bufferedReader;

        public CurrentNode(){}

        public CurrentNode(String curr, BufferedReader bufferedReader){
            this.curr= curr;
            this.bufferedReader = bufferedReader;
        }

        public String getCurr() {
            return curr;
        }

        public void setCurr(String curr) {
            this.curr = curr;
        }

        public BufferedReader getBufferedReader() {
            return bufferedReader;
        }

        public void setBufferedReader(BufferedReader bufferedReader) {
            this.bufferedReader = bufferedReader;
        }

        public void read() throws IOException {
            curr = bufferedReader.readLine();
        }

        public void close() throws IOException {
            bufferedReader.close();
        }
    }

    public static void main(String[] args) throws IOException {
        OuterSort sort = new OuterSort();
        List<String> splitFiles = sort.spiltFile("/Users/luzheqi/workspace/test/raw");
        List<String> reorderFiles = sort.reorderEachFile(splitFiles);
        sort.order(reorderFiles);
    }
}
