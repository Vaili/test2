package proj.stefan;

public class Main {

    public static void main(String[] args) {
        LogFilter filter = new LogFilter("C:\\Users\\Stefan\\IdeaProjects\\WebLog\\src\\proj\\stefan\\web.log.txt", "C:\\Users\\Stefan\\IdeaProjects\\WebLog\\src\\proj\\stefan\\weblog_out.txt");
        filter.translate();

        return;
    }
}
