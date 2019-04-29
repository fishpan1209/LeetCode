class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        most_freq = collections.Counter(tasks).most_common()
        maxCount, maxTask = most_freq[0][1], 0
        for task in most_freq:
            if task[1] == maxCount:
                maxTask += 1
        
        noPart = maxCount -1
        partLength = n - (maxTask - 1)
        emptySlots = noPart * partLength
        availableTask = len(tasks) - maxCount * maxTask
        idle = max(0, emptySlots - availableTask)
        
        return len(tasks) + idle
