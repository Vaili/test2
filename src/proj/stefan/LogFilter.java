package proj.stefan;

import java.io.*;
import java.net.InetAddress;

public class LogFilter {
    private String input_file;
    private String output_file;

    /*******************************************/

    public LogFilter(String input_file, String output_file) {
        this.input_file = input_file;
        this.output_file = output_file;
    }

    public void translate() {
        try (BufferedReader br = new BufferedReader(
                new FileReader(this.input_file));
             BufferedWriter bw = new BufferedWriter(
                new FileWriter(this.output_file))
        ) {
            String line;
            String tokens[] = new String[4];

            while ((line = br.readLine()) != null) {
                tokens = line.split(" - - ");
                System.out.println("-------------------------------------\n");
                System.out.println(tokens[0]);


                byte[] ip_address = getBytesIP(tokens[0]);

                InetAddress address = InetAddress.getByAddress(ip_address);

                String hostName = address.getCanonicalHostName();
                hostName = hostName + " - - " + tokens[1] + "\n";

                System.out.println(hostName);

                bw.write(hostName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private byte[] getBytesIP(String token) {
        byte ip_address[] = new byte[4];
        int ip_address2[] = new int[4];
        String ip_tokens[] = token.split("\\.");

        System.out.println(ip_tokens[3]);

        for (int i = 0; i < 4; i++) {
            ip_address2[i] = Integer.parseInt(ip_tokens[i]);
            ip_address[i] = (byte) ip_address2[i];
            System.out.println(ip_address[i]);
        }
        return ip_address;
    }
}
