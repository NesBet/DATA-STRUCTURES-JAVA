public class NaturalMergeSorter {
    public int getSortedRunLength(int[] array, int arrayLength, int startIndex) {
        if (startIndex < 0 || startIndex >= arrayLength) {
            return 0;
        }

        int sortedLength = 1;
        int currentIndex = startIndex;

        while (currentIndex + 1 < arrayLength && array[currentIndex] <= array[currentIndex + 1]) {
            currentIndex++;
            sortedLength++;
        }

        return sortedLength;
    }

    public void naturalMergeSort(int[] array, int arrayLength) {
        int currentIndex = 0;
        int mergeCount = 0;

        while (true) {
            int firstRunLength = getSortedRunLength(array, arrayLength, currentIndex);

            if (firstRunLength == 0 || firstRunLength == arrayLength) {
                return;
            }

            int secondRunStartIndex = currentIndex + firstRunLength;
            int secondRunLength = getSortedRunLength(array, arrayLength, secondRunStartIndex);

            merge(array, currentIndex, currentIndex + firstRunLength - 1, secondRunStartIndex + secondRunLength - 1);
            mergeCount++;

            if (secondRunStartIndex + secondRunLength == arrayLength) {
                currentIndex = 0;
            } else {
                currentIndex = secondRunStartIndex + secondRunLength;
            }
        }
    }

    public void merge(int[] numbers, int leftFirst, int leftLast, int rightLast) {
        int mergedSize = rightLast - leftFirst + 1;
        int[] mergedNumbers = new int[mergedSize];
        int mergePos = 0;
        int leftPos = leftFirst;
        int rightPos = leftLast + 1;

        while (leftPos <= leftLast && rightPos <= rightLast) {
            if (numbers[leftPos] <= numbers[rightPos]) {
                mergedNumbers[mergePos] = numbers[leftPos];
                leftPos++;
            } else {
                mergedNumbers[mergePos] = numbers[rightPos];
                rightPos++;
            }
            mergePos++;
        }

        while (leftPos <= leftLast) {
            mergedNumbers[mergePos] = numbers[leftPos];
            leftPos++;
            mergePos++;
        }

        while (rightPos <= rightLast) {
            mergedNumbers[mergePos] = numbers[rightPos];
            rightPos++;
            mergePos++;
        }

        for (mergePos = 0; mergePos < mergedSize; mergePos++) {
            numbers[leftFirst + mergePos] = mergedNumbers[mergePos];
        }

        mergedNumbers = null;
    }
}
