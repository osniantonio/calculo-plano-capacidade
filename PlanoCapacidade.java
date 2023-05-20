public class PlanoCapacidade {
    public static void main(String[] args) {

        // Dados importantes

        double numMilhao = 1;

        // - 1Mi DAU (Daily Active Users);
        double dailyActiveUsers = numMilhao * Math.pow(10, 6);

        // - Cada usuário faz [numeroRequests] requests
        int numeroRequests = 5;

        // Cada request resulta em [requestSize]KB
        double requestSize = 50;

        // [numPercentageCompram]% comprarm 1 ingresso
        double numPercentageCompram = 5;

        double segundoPorDia = Math.pow(10, 5);

        // - Replication factor 3.
        double replicationFactor = 3;

        System.out.println("\n==================Iniciando calculos==================");

        // rps = req por dia / segundos por dia
        double requestsPorDia = numeroRequests * dailyActiveUsers;
        double requestsPorSegundo = (numeroRequests * dailyActiveUsers) / segundoPorDia;

        System.out.println("\n==================Dados importantes==================");
        System.out.println(numMilhao + "Mi DAU (Daily Active Users): " + dailyActiveUsers);
        System.out.println("Cada usuário faz " + numeroRequests + " requests ");
        System.out.println("Cada request resulta em " + numeroRequests + "KB");
        System.out.println(numPercentageCompram + " dos usuários compram 1 igresso");
        System.out.println("Reads vc Writes: 9:1");
        System.out.println("Pode ter picos de acesso");
        System.out.println("Segundos por dia: " + segundoPorDia);
        System.out.println("Replication factor para calcular Storage: " + replicationFactor);

        System.out.println("\n==================Requests==================");
        System.out.println("Requests por dia: " + requestsPorDia);
        System.out.println("Requests por segundo: " + requestsPorSegundo + " rps");
        System.out.println("- Reads vs Writes: 9:1;");
        double writesPorSegundo = requestsPorSegundo / 10;
        System.out.println("Requests writes por segundo: " + writesPorSegundo + " rps");
        System.out.println("Requests reads por segundo: " + (requestsPorSegundo - writesPorSegundo) + " rps");

        System.out.println("\n==================Compras==================");
        double numComprasPorDia = numPercentageCompram * Math.pow(10, 4);
        System.out.println(numPercentageCompram + "% de " + dailyActiveUsers + "="
                + numComprasPorDia + " compras por dia");
        System.out.println((numComprasPorDia / segundoPorDia) + " compras por segundo");

        // - Cada request resulta em [requestSize] KB;
        System.out.println("\n==================Bandwith==================");
        double bandwithKbps = requestsPorSegundo * requestSize;
        System.out.println(requestsPorSegundo + "*" + requestSize + "KB = " + bandwithKbps + " KB/s");
        System.out.println("ou->");
        double bandwithMbps = bandwithKbps / Math.pow(10, 3);
        System.out.println(bandwithMbps + " MB/s");

        System.out.println("\n==================Storage==================");
        System.out.println("writes per sec * request size * replication factor");
        double storageKBPorSegundo = writesPorSegundo * requestSize * replicationFactor;
        double storageMBPorSegundo = storageKBPorSegundo / 1000;
        System.out.println(storageKBPorSegundo + " KB/s");
        System.out.println(storageMBPorSegundo + " MB/s");

        System.out.println("\nStorage por dia:");
        double storageMbPorDia = storageMBPorSegundo * segundoPorDia;
        double storageGbPorDia = storageMbPorDia / Math.pow(10, 3);
        double storageTbPorDia = storageGbPorDia / Math.pow(10, 3);
        System.out.println(storageMBPorSegundo + "MB/s * 10^5 = " + storageMbPorDia + " MB");
        System.out.println(storageMbPorDia + "MB/s / 10^3 = " + storageGbPorDia + " GB");
        System.out.println(storageGbPorDia + "GB/s / 10^3 = " + storageTbPorDia + " TB");

        System.out.println("\nStorage por ano:");
        double storageMbPorAno = storageMBPorSegundo * (3.65 * Math.pow(10, 7));
        double storageGbPorAno = storageMbPorAno / Math.pow(10, 3);
        double storageTbPorAno = storageMbPorAno / Math.pow(10, 6);
        System.out.println(storageMbPorAno + "MB");
        System.out.println(storageGbPorAno + "GB");
        System.out.println(storageTbPorAno + "TB");

        System.out.println("\nStorage em 5 ano:");
        double storageMbEmCincoAno = storageMBPorSegundo * (2 * Math.pow(10, 8));
        double storageGbEmCincoAno = storageMbEmCincoAno / Math.pow(10, 3);
        double storageTbEmCincoAno = storageMbEmCincoAno / Math.pow(10, 6);
        System.out.println(storageMbEmCincoAno + "MB");
        System.out.println(storageGbEmCincoAno + "GB");
        System.out.println(storageTbEmCincoAno + "TB");

        System.out.println("\n==================Calculos finalizados==================");
    }
}