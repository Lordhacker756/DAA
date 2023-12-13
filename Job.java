import java.util.*;

class Job {
    int profit;
    int deadline;
    int isVisited;

    Job() {
        profit = 0;
        deadline = 0;
        isVisited = 0;
    }

    Job(int profit, int deadline, int isVisited) {
        this.profit = profit;
        this.deadline = deadline;
        this.isVisited = isVisited;
    }
}

class JobSequencing {
    static int numberOfJobs;

    static int findJobIndex(Job jobs[], int profit) {
        for (int i = 0; i < numberOfJobs; ++i)
            if (jobs[i].profit == profit)
                return i;
        return 0;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of jobs");
        numberOfJobs = scanner.nextInt();

        int maxDeadline = 0;
        Job jobs[] = new Job[numberOfJobs];

        for (int i = 0; i < numberOfJobs; ++i) {
            System.out.println("Enter profit and deadline(p d)");
            int profit = scanner.nextInt();
            int deadline = scanner.nextInt();

            if (maxDeadline < deadline)
                maxDeadline = deadline;

            jobs[i] = new Job(profit, deadline, 0);
        }

        Arrays.sort(jobs, (a, b) -> a.deadline - b.deadline);

        System.out.println("The jobs are as follows ");
        for (int i = 0; i < numberOfJobs; ++i)
            System.out.println("Job " + i + " Profit = " + jobs[i].profit + " Deadline = " + jobs[i].deadline);

        int[] selectedJobs = new int[maxDeadline];
        for (int i = 0; i < maxDeadline; ++i)
            selectedJobs[i] = 0;

        for (int i = 0; i < numberOfJobs; ++i) {
            int count = 0;
            for (int j = 0; j < numberOfJobs; ++j) {
                if (count < jobs[j].deadline && jobs[j].isVisited == 0 && count < maxDeadline && jobs[j].profit > selectedJobs[count]) {
                    int jobIndex = 0;
                    if (selectedJobs[count] != 0) {
                        jobIndex = findJobIndex(jobs, selectedJobs[count]);
                        jobs[jobIndex].isVisited = 0;
                    }
                    selectedJobs[count] = jobs[j].profit;
                    jobs[j].isVisited = 1;
                    ++count;
                }
            }
        }

        int totalProfit = 0;
        for (int i = 0; i < maxDeadline; ++i)
            totalProfit += selectedJobs[i];

        System.out.println("The maximum profit is " + totalProfit);
    }
}