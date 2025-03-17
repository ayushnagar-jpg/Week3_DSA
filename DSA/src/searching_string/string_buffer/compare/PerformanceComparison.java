package searching_string.string_buffer.compare;

public class PerformanceComparison {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int iteration = 1000000;
		String txt = "hello";
		
		 // ---------- StringBuffer ----------
        long startTimeBuffer = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < iteration; i++) {
            stringBuffer.append(txt);
        }

        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;
        System.out.println("StringBuffer time: " + durationBuffer / 1_000_000 + " ms");
        
        // ---------- StringBuilder ----------
        long startTimeBuilder = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < iteration; i++) {
            stringBuilder.append(txt);
        }

        long endTimeBuilder = System.nanoTime();
        long durationBuilder = endTimeBuilder - startTimeBuilder;
        System.out.println("StringBuilder time: " + durationBuilder / 1_000_000 + " ms");
	}

}
