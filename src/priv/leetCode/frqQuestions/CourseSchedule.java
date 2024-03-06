package priv.leetCode.frqQuestions;

import java.util.ArrayDeque;
import java.util.Queue;

/*
    Given a total number of numCourses you have to take. Given an array prerequisites where
    p[i] = [ai, bi] -> must take bi before taking ai. Return true if you can finish all courses
 */
public class CourseSchedule {
    public static void main(String[] args) {
        assert canFinish(2, new int[][]{ {1, 0} });
        assert !canFinish(2, new int[][]{ {1, 0}, {0, 1}});
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preReqMap = new int[numCourses];
        for (int[] p : prerequisites) {
            preReqMap[p[0]]++;
        }
        Queue<Integer> classCanTake = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (preReqMap[i] == 0) {
                classCanTake.add(i);
            }
        }
        int classCompleted = 0;
        while (!classCanTake.isEmpty()) {
            int classToTake = classCanTake.poll();
            classCompleted++;
            for (int[] p : prerequisites) {
                if (p[1] == classToTake) {
                    preReqMap[p[0]]--;
                    if (preReqMap[p[0]] == 0) {
                        classCanTake.add(p[0]);
                    }
                }
            }
        }
        return classCompleted == numCourses;
    }

    private static int[] getClassTakenOrder(int numCourses, int[][] prerequisites) {
        int[] degreeMap = new int[numCourses];
        for (int[] p : prerequisites) {
            degreeMap[p[0]]++;
        }
        Queue<Integer> classToTake = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (degreeMap[i] == 0) {
                classToTake.add(i);
            }
        }
        int i = 0;
        int[] classSchedule = new int[numCourses];
        while (!classToTake.isEmpty()) {
            int takenClass = classToTake.poll();
            classSchedule[i] = takenClass;
            i++;
            for (int[] p : prerequisites) {
                if (p[1] == takenClass) {
                    degreeMap[p[0]]--;
                    if (degreeMap[p[0]] == 0) {
                        classToTake.add(p[0]);
                    }
                }
            }
        }
        return i == numCourses ? classSchedule : new int[]{};
    }
}
