package jp.co.nss.hrm.backend.common.util.SmsTentcent;

public class Notify2Supplier {

    private static final String templateId = "1245713";

    public static void sendByGroup(String[] phoneNumberSet, String hospitalName) {
        try {
            String[] _templateParamSet = {hospitalName};

            SmsTencent.send(templateId, phoneNumberSet, _templateParamSet);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
