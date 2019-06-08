class No12IntegerToRoman {
  public String intToRoman(int num) {
    StringBuilder res = new StringBuilder();
    if(num >= 1000) {
      int times = num / 1000;
      for (int i=0; i<times; i++) {
        res.append("M");
      }
      num = num % 1000;
    }
    if(num >= 900) {
      res.append("CM");
      num = num - 900;
    }
    if(num >= 500) {
      res.append("D");
      num = num - 500;
    }
    if(num >= 400) {
      res.append("CD");
      num = num - 400;
    }
    if(num >= 100) {
      int times = num / 100;
      for (int i=0; i<times; i++) {
        res.append("C");
      }
      num = num % 100;
    }
    if(num >= 90) {
      res.append("XC");
      num = num - 90;
    }
    if(num >= 50) {
      res.append("L");
      num = num - 50;
    }
    if(num >= 40) {
      res.append("XL");
      num = num - 40;
    }
    if(num >= 10) {
      int times = num / 10;
      for (int i=0; i<times; i++) {
        res.append("X");
      }
      num = num % 10;
    }
    if(num >= 9) {
      res.append("IX");
      num = num - 9;
    }
    if(num >= 5) {
      res.append("V");
      num = num - 5;
    }
    if(num >= 4) {
      res.append("IV");
      num = num - 4;
    }
    if(num >= 1) {
      for (int i=0; i<num; i++) {
        res.append("I");
      }
    }
    return res.toString();
  }
}