package function;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import classes.Vax;
import classes.VaxReg;
import classes.VaxRegistration;
import classesstate.VaxDefaultState;
import classesstate.VaxJohorState;
import classesstate.VaxKLState;
import classesstate.VaxKedahState;
import classesstate.VaxKelantanState;
import classesstate.VaxLabuanState;
import classesstate.VaxMelakaState;
import classesstate.VaxN9State;
import classesstate.VaxPahangState;
import classesstate.VaxPerakState;
import classesstate.VaxPerlisState;
import classesstate.VaxPinangState;
import classesstate.VaxPutrajayaState;
import classesstate.VaxSabahState;
import classesstate.VaxSarawakState;
import classesstate.VaxSelangorState;
import classesstate.VaxTerengganuState;
import dataset.VaxData;
import dataset.VaxData2;
import dataset.VaxRegData;
import dataset.VaxRegData2;

public class FileUtil {
    public static void readVaxCSVFileFromURLToVaxList (String linknation, String linkstate, String identifier) throws Throwable {
        String vaxnation = readCSVFilefromURL(linknation);
        String vaxstate = readCSVFilefromURL(linkstate);
        if(identifier.equals("Vax")) {
            FileUtil.convertStringtoVaxList(vaxnation, vaxstate);
            FileUtil.loadVaxDatatoVaxData2();

        } else {
            FileUtil.convertStringtoVaxRegList(vaxnation, vaxstate);
            FileUtil.loadVaxRegDatatoVaxRegData2();
        }
    }

    public static String readCSVFilefromURL (String link) throws Throwable {
        URL url = new URL(link);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        Map<String, List<String>> httpheader = http.getHeaderFields();

        // If URL is getting 301 and 302 redirection HTTP code then get new URL link
        // Optional loop to make sure URL is not redirected to anywhere
        for (String header : httpheader.get(null)) {
                if (header.contains(" 302 ") || header.contains(" 301 ")) {
                        link = httpheader.get("Location").get(0);
                        url = new URL(link);
                        http = (HttpURLConnection) url.openConnection();
                        httpheader = http.getHeaderFields();
                }
        }
        InputStream httpstream = http.getInputStream();
        return ConvertStreamToString(httpstream);
    }

    public static final String ConvertStreamToString(InputStream stream) throws IOException {
        if (stream != null) {
            Writer writer = new StringWriter();

            char[] buffer = new char[2048];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
                int counter;
                while ((counter = reader.read(buffer)) != -1) {
                        writer.write(buffer, 0, counter);
                }
            } finally {
                stream.close();
            }
            return writer.toString();
        } else {
            return "No Contents";
        }
    }

    public static void convertStringtoVaxList (String vaxmalaysia, String vaxstate) {
        VaxData.create();

        String[] Line = vaxmalaysia.split("\\r?\\n");
        String[] Line2 = vaxstate.split("\\r?\\n");

        int counter = 0;

        for(int i = 1; i < Line.length; i++) {
            Vax newVax = new Vax();
            String[] LineDetail = Line[i].split(",");
            String[] modifiedArray = Arrays.copyOfRange(LineDetail, 1, LineDetail.length);
            Integer[] LineDetailInteger = Arrays.stream(modifiedArray)
                .map(o -> Integer.parseInt(o))
                .toArray(Integer[]::new);

            VaxDefaultState<Date, Integer> defaultstate = new VaxDefaultState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail[0]), LineDetailInteger[0], LineDetailInteger[1], LineDetailInteger[2], LineDetailInteger[3], LineDetailInteger[4], LineDetailInteger[5],
                            LineDetailInteger[6],LineDetailInteger[7],LineDetailInteger[8],LineDetailInteger[9],LineDetailInteger[10],LineDetailInteger[11],
                            LineDetailInteger[12],LineDetailInteger[13],LineDetailInteger[14],LineDetailInteger[15],LineDetailInteger[16],LineDetailInteger[17],
                            LineDetailInteger[18],LineDetailInteger[19],LineDetailInteger[20],LineDetailInteger[21],LineDetailInteger[22],LineDetailInteger[23],
                            LineDetailInteger[24],LineDetailInteger[25],LineDetailInteger[26],LineDetailInteger[27],LineDetailInteger[28],LineDetailInteger[29],
                            LineDetailInteger[30],LineDetailInteger[31],LineDetailInteger[32]);

            newVax.setDefaultstate(defaultstate);

            for(int j = 1; j<17; j++) {
                counter++;
                String[] LineDetail2 = Line2[counter].split(",");
                String[] modifiedArray2 = Arrays.copyOfRange(LineDetail2, 2, LineDetail2.length);
                Integer[] LineDetailInteger2 = Arrays.stream(modifiedArray2)
                    .map(o -> Integer.parseInt(o))
                    .toArray(Integer[]::new);


                if(j == 1) {
                    VaxJohorState<Date, Integer> johorstate = new VaxJohorState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setJohorstate(johorstate);
                } else if (j == 2) { 
                    VaxKedahState<Date, Integer> kedahstate = new VaxKedahState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setKedahstate(kedahstate);
                } else if (j == 3) { 
                    VaxKelantanState<Date, Integer> kelantanstate = new VaxKelantanState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setKelantanstate(kelantanstate);
                } else if (j == 4) { 
                    VaxMelakaState<Date, Integer> melakastate = new VaxMelakaState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setMelakastate(melakastate);
                } else if (j == 5) { 
                    VaxN9State<Date, Integer> n9state = new VaxN9State<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setN9state(n9state);
                } else if (j == 6) { 
                    VaxPahangState<Date, Integer> pahangstate = new VaxPahangState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setPahangstate(pahangstate);
                } else if (j == 7) { 
                    VaxPerakState<Date, Integer> perakstate = new VaxPerakState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setPerakstate(perakstate);
                } else if (j == 8) { 
                    VaxPerlisState<Date, Integer> perlisstate = new VaxPerlisState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setPerlisstate(perlisstate);
                } else if (j == 9) { 
                    VaxPinangState<Date, Integer> pinangstate = new VaxPinangState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setPinangstate(pinangstate);
                } else if (j == 10) { 
                    VaxSabahState<Date, Integer> sabahstate = new VaxSabahState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setSabahstate(sabahstate);
                } else if (j == 11) { 
                    VaxSarawakState<Date, Integer> sarawakstate = new VaxSarawakState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setSarawakstate(sarawakstate);
                } else if (j == 12) { 
                    VaxSelangorState<Date, Integer> selangorstate = new VaxSelangorState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setSelangorstate(selangorstate);
                } else if (j == 13) { 
                    VaxTerengganuState<Date, Integer> terengganustate = new VaxTerengganuState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setTerengganustate(terengganustate);
                } else if (j == 14) { 
                    VaxKLState<Date, Integer> klstate = new VaxKLState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setKlstate(klstate);
                } else if (j == 15) { 
                    VaxLabuanState<Date, Integer> labuanstate = new VaxLabuanState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setLabuanstate(labuanstate);
                } else if (j == 16) { 
                    VaxPutrajayaState<Date, Integer> putrajayastate = new VaxPutrajayaState<Date, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5],
                                    LineDetailInteger2[6],LineDetailInteger2[7],LineDetailInteger2[8],LineDetailInteger2[9],LineDetailInteger2[10],LineDetailInteger2[11],
                                    LineDetailInteger2[12],LineDetailInteger2[13],LineDetailInteger2[14],LineDetailInteger2[15],LineDetailInteger2[16],LineDetailInteger2[17],
                                    LineDetailInteger2[18],LineDetailInteger2[19],LineDetailInteger2[20],LineDetailInteger2[21],LineDetailInteger2[22],LineDetailInteger2[23],
                                    LineDetailInteger2[24],LineDetailInteger2[25],LineDetailInteger2[26],LineDetailInteger2[27],LineDetailInteger2[28],LineDetailInteger2[29],
                                    LineDetailInteger2[30],LineDetailInteger2[31],LineDetailInteger2[32]);
                    newVax.setPutrajayastate(putrajayastate);
                }
            }
            newVax.setDate(defaultstate.getDate());
            VaxData.add(newVax);
        }
    }

    public static void convertStringtoVaxRegList (String vaxregmalaysia, String vaxregstate) {
        VaxRegData.create();

        String[] Line = vaxregmalaysia.split(" ");
        String[] Line2 = vaxregstate.split("\n");
        int counter = 0;
        Line = Line[0].split("\\r?\\n");

        for(int i = 1; i < Line.length; i++) {
            VaxReg newVaxReg = new VaxReg();
            String[] LineDetail = Line[i].split(",");
            String[] modifiedArray = Arrays.copyOfRange(LineDetail, 2, LineDetail.length);
            Integer[] LineDetailInteger = Arrays.stream(modifiedArray)
                .map(o -> Integer.parseInt(o))
                .toArray(Integer[]::new);


            VaxRegistration<Date, String, Integer> defaultregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail[0]), LineDetail[1], LineDetailInteger[0], LineDetailInteger[1], LineDetailInteger[2], LineDetailInteger[3], LineDetailInteger[4], LineDetailInteger[5], LineDetailInteger[6],
                            LineDetailInteger[7], LineDetailInteger[8], LineDetailInteger[9], LineDetailInteger[10]);

            newVaxReg.setDefaultregstate(defaultregstate);

            for(int j = 1; j<17; j++) {
                counter++;
                String[] LineDetail2 = Line2[counter].split(",");
                String[] modifiedArray2 = Arrays.copyOfRange(LineDetail2, 2, LineDetail2.length);
                Integer[] LineDetailInteger2 = Arrays.stream(modifiedArray2)
                    .map(o -> Integer.parseInt(o))
                    .toArray(Integer[]::new);


                    if(j == 1) {
                            VaxRegistration<Date, String, Integer> johorregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setJohorregstate(johorregstate);
                    } else if (j == 2) { 
                            VaxRegistration<Date, String, Integer> kedahregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setKedahregstate(kedahregstate);
                    } else if (j == 3) { 
                            VaxRegistration<Date, String, Integer> kelantanregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setKelantanregstate(kelantanregstate);
                    } else if (j == 4) { 
                            VaxRegistration<Date, String, Integer> melakaregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setMelakaregstate(melakaregstate);
                    } else if (j == 5) { 
                            VaxRegistration<Date, String, Integer> n9regstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setN9regstate(n9regstate);
                    } else if (j == 6) { 
                            VaxRegistration<Date, String, Integer> pahangregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setPahangregstate(pahangregstate);
                    } else if (j == 7) { 
                            VaxRegistration<Date, String, Integer> perakregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setPerakregstate(perakregstate);
                    } else if (j == 8) { 
                            VaxRegistration<Date, String, Integer> perlisregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setPerlisregstate(perlisregstate);
                    } else if (j == 9) { 
                            VaxRegistration<Date, String, Integer> pinangregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setPinangregstate(pinangregstate);
                    } else if (j == 10) { 
                            VaxRegistration<Date, String, Integer> sabahregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setSabahregstate(sabahregstate);
                    } else if (j == 11) { 
                            VaxRegistration<Date, String, Integer> sarawakregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setSarawakregstate(sarawakregstate);
                    } else if (j == 12) { 
                            VaxRegistration<Date, String, Integer> selangorregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setSelangorregstate(selangorregstate);
                    } else if (j == 13) { 
                            VaxRegistration<Date, String, Integer> terengganuregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setTerengganuregstate(terengganuregstate);
                    } else if (j == 14) { 
                            VaxRegistration<Date, String, Integer> klregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setKlregstate(klregstate);
                    } else if (j == 15) { 
                            VaxRegistration<Date, String, Integer> labuanregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setLabuanregstate(labuanregstate);
                    } else if (j == 16) { 
                            VaxRegistration<Date, String, Integer> putrajayaregstate = new VaxRegistration<Date, String, Integer>(DateReformat.convertStringtoDate(LineDetail2[0]), LineDetail2[1], LineDetailInteger2[0], LineDetailInteger2[1], LineDetailInteger2[2], LineDetailInteger2[3], LineDetailInteger2[4], LineDetailInteger2[5], LineDetailInteger2[6],
                                            LineDetailInteger2[7], LineDetailInteger2[8], LineDetailInteger2[9], LineDetailInteger2[10]);
                            newVaxReg.setPutrajayaregstate(putrajayaregstate);
                    }
            }
            newVaxReg.setDate(defaultregstate.getDate());
            VaxRegData.add(newVaxReg);
        }
    }

    public static void loadVaxDatatoVaxData2 () {
        VaxData2.create();
        List<Vax> vaxlist = VaxData.getAllVaxData();
        for(Vax vax : vaxlist) {
            VaxData2.add(vax.getDefaultstate());
            VaxData2.add(vax.getJohorstate());
            VaxData2.add(vax.getKedahstate());
            VaxData2.add(vax.getKelantanstate());
            VaxData2.add(vax.getMelakastate());
            VaxData2.add(vax.getN9state());
            VaxData2.add(vax.getPahangstate());
            VaxData2.add(vax.getPerakstate());
            VaxData2.add(vax.getPerlisstate());
            VaxData2.add(vax.getPinangstate());
            VaxData2.add(vax.getSabahstate());
            VaxData2.add(vax.getSarawakstate());
            VaxData2.add(vax.getSelangorstate());
            VaxData2.add(vax.getTerengganustate());
            VaxData2.add(vax.getKlstate());
            VaxData2.add(vax.getLabuanstate());
            VaxData2.add(vax.getPutrajayastate());
        }
        System.out.println("Loaded to VaxData2 from VaxData");
    }

    public static void loadVaxRegDatatoVaxRegData2 () {
        VaxRegData2.create();
        List<VaxReg> vaxreglist = VaxRegData.getAllVaxRegData();
        for(VaxReg vaxreg : vaxreglist) {
            VaxRegData2.add(vaxreg.getDefaultregstate());
            VaxRegData2.add(vaxreg.getJohorregstate());
            VaxRegData2.add(vaxreg.getKedahregstate());
            VaxRegData2.add(vaxreg.getKelantanregstate());
            VaxRegData2.add(vaxreg.getMelakaregstate());
            VaxRegData2.add(vaxreg.getN9regstate());
            VaxRegData2.add(vaxreg.getPahangregstate());
            VaxRegData2.add(vaxreg.getPerakregstate());
            VaxRegData2.add(vaxreg.getPerlisregstate());
            VaxRegData2.add(vaxreg.getPinangregstate());
            VaxRegData2.add(vaxreg.getSabahregstate());
            VaxRegData2.add(vaxreg.getSarawakregstate());
            VaxRegData2.add(vaxreg.getSelangorregstate());
            VaxRegData2.add(vaxreg.getTerengganuregstate());
            VaxRegData2.add(vaxreg.getKlregstate());
            VaxRegData2.add(vaxreg.getLabuanregstate());
            VaxRegData2.add(vaxreg.getPutrajayaregstate());
        }
        System.out.println("Loaded to VaxRegData2 from VaxRegData");
    }
}

