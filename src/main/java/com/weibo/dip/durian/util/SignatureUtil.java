package com.weibo.dip.durian.util;

import com.google.common.base.Preconditions;
import com.weibo.dip.durian.Symbols;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang.CharEncoding;
import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Encoder;

/** SignatureUtil. */
public class SignatureUtil {
  private static final String HMAC_SHA1 = "HmacSHA1";

  /**
   * Signature generate.
   *
   * @param parameters http get/post parameters
   * @param secretKey secret key
   * @return signature
   * @throws UnsupportedEncodingException if utf-8 encode unsupported
   * @throws NoSuchAlgorithmException if algorithm HmacSHA1 unsupported
   * @throws InvalidKeyException if secret key spec build error
   */
  public static String generate(Map<String, String> parameters, String secretKey)
      throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
    Preconditions.checkState(Objects.nonNull(parameters), "signature parameters is null");
    Preconditions.checkState(Objects.nonNull(secretKey), "signature secretKey is null");

    TreeMap<String, String> sortedParameters = new TreeMap<>(parameters);

    List<String> parameterStrs = new ArrayList<>();

    for (Entry<String, String> parameter : sortedParameters.entrySet()) {
      String name = parameter.getKey();
      String value = parameter.getValue();

      value = URLEncoder.encode(value, CharEncoding.UTF_8);

      parameterStrs.add(name + Symbols.EQUAL + value);
    }

    String parameterStr = StringUtils.join(parameterStrs, Symbols.AMPERSAND);

    Mac mac = Mac.getInstance(HMAC_SHA1);

    SecretKeySpec spec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), HMAC_SHA1);
    mac.init(spec);

    byte[] hmac = mac.doFinal(parameterStr.getBytes(StandardCharsets.UTF_8));

    return new BASE64Encoder().encode(hmac);
  }
}
