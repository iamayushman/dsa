package com.ayushman.interview.thales;

import java.io.File;
import java.util.Optional;

/**
 * <a
 * href="https://www.amazon.in/Core-Java-Fundamentals-12th-Pearson/dp/8119847334/ref=pd_rhf_ee_s_ci_mcx_mr_hp_d_d_sccl_2_1/259-3826171-8548012?pd_rd_w=OOgXL&content-id=amzn1.sym.27b2fb5a-5c6b-4aba-8a0c-71fb41193d86:amzn1.symc.1042562f-235b-4049-91eb-05d433a5d976&pf_rd_p=27b2fb5a-5c6b-4aba-8a0c-71fb41193d86&pf_rd_r=KS0A0CJE7DRD15EWE5B1&pd_rd_wg=VK50t&pd_rd_r=2a034922-775a-4afd-aac9-f2c4e2b97a8c&pd_rd_i=8119847334&psc=1">Core
 * Java Volume I - Fundamentals, 12th Edition - Pearson Paperback – 4 December 2023 by Horstmann
 * (Author)</a>
 *
 * <p><a
 * href="https://www.amazon.in/JOSHUA-BLOCH-EFFECTIVE-JAVA-THIRD/dp/B0CTTMGHW8/ref=pd_rhf_ee_s_ci_mcx_mr_hp_d_d_sccl_2_2/259-3826171-8548012?pd_rd_w=OOgXL&content-id=amzn1.sym.27b2fb5a-5c6b-4aba-8a0c-71fb41193d86:amzn1.symc.1042562f-235b-4049-91eb-05d433a5d976&pf_rd_p=27b2fb5a-5c6b-4aba-8a0c-71fb41193d86&pf_rd_r=KS0A0CJE7DRD15EWE5B1&pd_rd_wg=VK50t&pd_rd_r=2a034922-775a-4afd-aac9-f2c4e2b97a8c&pd_rd_i=B0CTTMGHW8&psc=1">JOSHUA
 * BLOCH EFFECTIVE JAVA THIRD EDITION Paperback – 1 January 2023 by AAKASH (Author)</a>
 */
public class Test {

  public static void main(String[] args) {

    Optional<String> maybeUsername = getUserNameById(3);
    String maybeUsername2 = getUserNameById2(3);
    /*
     * Optional was introduced to make null checked exception
     * */
    String s = maybeUsername.get();
    maybeUsername.ifPresent(
        i -> {
          //
        });

    if (maybeUsername.isEmpty()) {
      //
    } else {
      //
    }

    if (maybeUsername2 != null) {
      //
    } else {
      //
    }
  }

  public static Optional<String> getUserNameById(int id) {
    if (id == 4) {
      return Optional.of("ABc");
    }
    return Optional.empty();
  }

  public static String getUserNameById2(int id) {
    if (id == 4) {
      return "ABc";
    }
    return null;
  }
}

/** Is it mutable or not : NO */
class StringEx {
  String val;

  void concat(String c) {
    val += c;
  }
}

class A {
  public static void main(String[] args) {

    try {
      File file = new File("abc.csv");
    } catch (Exception e) {
      /** NOTE: don't loose exception while throwing custom exception. */
      throw new CSVParsingException("CSV file not found");
    }
  }
}

class CSVParsingException extends RuntimeException {

  public CSVParsingException(String csvFileNotFound) {
    super(csvFileNotFound);
  }
}
