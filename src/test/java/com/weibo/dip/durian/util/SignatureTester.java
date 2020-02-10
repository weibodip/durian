package com.weibo.dip.durian.util;

import java.util.HashMap;
import java.util.Map;

/** Created by yurun on 2020-02-10. */
public class SignatureTester {

  public static void main(String[] args) throws Exception {
    String accessKey = "abc";
    String secretKey = "1234qwer";

    Map<String, String> parameters = new HashMap<>();

    parameters.put("key1", "value1");
    parameters.put("key3", "value 3");
    parameters.put("key2", "v a lue2");

    parameters.put("accesskey", accessKey);

    String signature = SignatureUtil.generate(parameters, secretKey);

    System.out.println(signature);
  }
}
