class No13RomanToInteger {
  public int romanToInt(String s) {
    int res = 0;
    char[] array = s.toCharArray();
    for(int i=0; i<array.length; i++) {
      char c = array[i];
      switch (c) {
        case 'M':
          if (i!=0 && array[i-1]=='C') {
            res -= 200;
          } 
          res += 1000;
          break;
        case 'D':
          if (i!=0 && array[i-1]=='C') {
            res -= 200;
          }
          res += 500;
          break;
        case 'C':
          if (i!=0 && array[i-1]=='X') {
            res -= 20;
          }
          res += 100;
          break;
        case 'L':
          if (i!=0 && array[i-1]=='X') {
            res -= 20;
          }
          res += 50;        
          break;
        case 'X':
          if (i!=0 && array[i-1]=='I') {
            res -= 2;
          }
          res += 10;  
          break;
        case 'V':
          if (i!=0 && array[i-1]=='I') {
            res -= 2;
          }
          res += 5;  
          break;
        case 'I':
          res += 1;
          break;
      }
    }
    return res;
  }
}