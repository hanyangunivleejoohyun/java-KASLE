package test;

public class UnicodeKorean {
	/* **********************************************
	 * ���� ���� �и�
	 * ������ -> ���ä����Ť�����,    �ٺ� -> ��������
	 * **********************************************/
	/** �ʼ� - ��(��), ��(��) ��(��) */
	public static char[] arrChoSung = { 0x3131, 0x3132, 0x3134, 0x3137, 0x3138,
			0x3139, 0x3141, 0x3142, 0x3143, 0x3145, 0x3146, 0x3147, 0x3148,
			0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e };
	/** �߼� - ��(��), ��(��), ��(��)*/
	public static char[] arrJungSung = { 0x314f, 0x3150, 0x3151, 0x3152,
			0x3153, 0x3154, 0x3155, 0x3156, 0x3157, 0x3158, 0x3159, 0x315a,
			0x315b, 0x315c, 0x315d, 0x315e, 0x315f, 0x3160, 0x3161, 0x3162,
			0x3163 };
	/** ���� - ��(����), ��(��) õ(��) */
	public static char[] arrJongSung = { 0x0000, 0x3131, 0x3132, 0x3133,
			0x3134, 0x3135, 0x3136, 0x3137, 0x3139, 0x313a, 0x313b, 0x313c,
			0x313d, 0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145,
			0x3146, 0x3147, 0x3148, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e };
	
	
	/* **********************************************
	 * ���ĺ����� ��ȯ
	 * ������ -> tjfdustn, ���� -> ajdcnd 
	 * **********************************************/
	/** �ʼ� - ��(��), ��(��) ��(��) */
	public static String[] arrChoSungEng = { "r", "R", "s", "e", "E",
		"f", "a", "q", "Q", "t", "T", "d", "w",
		"W", "c", "z", "x", "v", "g" };
	
	/** �߼� - ��(��), ��(��), ��(��)*/
	public static String[] arrJungSungEng = { "k", "o", "i", "O",
		"j", "p", "u", "P", "h", "hk", "ho", "hl",
		"y", "n", "nj", "np", "nl", "b", "m", "ml",
		"l" };
	
	/** ���� - ��(����), ��(��) õ(��) */
	public static String[] arrJongSungEng = { "", "r", "R", "rt",
		"s", "sw", "sg", "e", "f", "fr", "fa", "fq",
		"ft", "fx", "fv", "fg", "a", "q", "qt", "t",
		"T", "d", "w", "c", "z", "x", "v", "g" };
	
	/** ���� ���� - ��,��,��,��... (��,��,���� ��������(�ʼ�)���� �������� ������������ �Ⱦ���) */
	public static String[] arrSingleJaumEng = { "r", "R", "rt",
		"s", "sw", "sg", "e","E" ,"f", "fr", "fa", "fq",
		"ft", "fx", "fv", "fg", "a", "q","Q", "qt", "t",
		"T", "d", "w", "W", "c", "z", "x", "v", "g" };
	
	public static char[] sd={'��','��','��','��','��','��','��','��','��','��','��','��','��','��',
						'��','��','��','��','��','��','��','��','��','��','��','��','��','��','��','��','��'};
	
	public static int UnicodetoNum(char a)
	{
		for(int i=0;i<sd.length;i++)
		{
			if(a==sd[i])
				return i+1;
		}
		return 0;
	}
	
	public static String divide(String word) {

		String result		= "";									// ��� ������ ����
		String resultEng	= "";									// ���ĺ�����
		
		for (int i = 0; i < word.length(); i++) {
			
			/*  �ѱ��ھ� �о���δ�. */
			char chars = (char) (word.charAt(i) - 0xAC00);

			if (chars >= 0 && chars <= 11172) {
				/* A. ������ ������ ������ �����ΰ�� */

				/* A-1. ��/��/���� �и� */
				int chosung 	= chars / (21 * 28);
				int jungsung 	= chars % (21 * 28) / 28;
				int jongsung 	= chars % (21 * 28) % 28;

				
				/* A-2. result�� ��� */
				result = result + arrChoSung[chosung] + arrJungSung[jungsung];

				
				/* �����и� */
				if (jongsung != 0x0000) {
					/* A-3. ������ �����Ұ�� result�� ��´� */
					result =  result + arrJongSung[jongsung];
				}

				/* ���ĺ����� */
				resultEng = resultEng + arrChoSungEng[chosung] + arrJungSungEng[jungsung];
				if (jongsung != 0x0000) {
					/* A-3. ������ �����Ұ�� result�� ��´� */
					resultEng =  resultEng + arrJongSungEng[jongsung];
				}

			} else {
				/* B. �ѱ��� �ƴϰų� ������ ������� */
				
				/* �����и� */
				result = result + ((char)(chars + 0xAC00));
				
				/* ���ĺ����� */
				if( chars>=34097 && chars<=34126){
					/* ���������� ��� */
					int jaum 	= (chars-34097);
					resultEng = resultEng + arrSingleJaumEng[jaum];
				} else if( chars>=34127 && chars<=34147) {
					/* ���ϸ����� ��� */
					int moum 	= (chars-34127);
					resultEng = resultEng + arrJungSungEng[moum];
				} else {
					/* ���ĺ��� ��� */
					resultEng = resultEng + ((char)(chars + 0xAC00));
				}
			}//if
			
		}//for

	
		return result;
	}
}
