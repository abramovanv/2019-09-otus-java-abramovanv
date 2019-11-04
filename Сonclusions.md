Параметры запуска
-Xms256m
-Xmx256m
-XX:+HeapDumpOnOutOfMemoryError
-XX:+UseG1GC
-XX:+UseSerialGC
-XX:+UseParallelGC
-XX:+UseConcMarkSweepGC

GC/Parametrs	count elements	time of OOM		count collections	time collections (ms)	average (ms/count)	
												minor	major		minor	major			minor	major
G1				5 012 661		152				346		161			949		25286			2,74	157,06
Serial			4 861 242		268				67		375			794		98807			11,85	263,49
Parallel		4 872 809		187				69		167			884		65930			12,81	394,79
CMS				4 860 969		367				119		422			683		165069			5,74	391,16

Вывод:
для данного примера лучше использовать gc1 т.к.
1. минимальное время на minor и major сбороку
2. максимальное количество обработанных объектов до OOM
