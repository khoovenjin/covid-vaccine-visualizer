% Facts
total_registration(johor, 801267209).
total_registration(kedah, 381775777).
total_registration(kelantan, 258368353).
total_registration(melaka, 188532090).
total_registration(negeri_sembilan, 243650261).
total_registration(pahang, 285145365).
total_registration(perak, 455013525).
total_registration(perlis, 47633359).
total_registration(pulau_pinang, 380758940).
total_registration(sabah, 443783415).
total_registration(sarawak, 498580177).
total_registration(selangor, 1447204206).
total_registration(terengganu, 204709755).
total_registration(wp_kuala_lumpur, 540920146).
total_registration(wp_labuan, 18427840).
total_registration(wp_putrajaya, 26449297).

% Rules
merge_cases_to_list(List) :- findall((StateName, Registration), total_registration(StateName, Registration), List).

ascending_pivot(_, [], [], []).
ascending_pivot((Pivot1, Pivot2), [(Head1, Head2)|Tail], [(Head1, Head2)|List1], List2) :- Pivot2 > Head2, ascending_pivot((Pivot1, Pivot2), Tail, List1, List2).
ascending_pivot((Pivot1, Pivot2), [(Head1, Head2)|Tail], List1, [(Head1, Head2)|List2]) :- ascending_pivot((Pivot1, Pivot2), Tail, List1, List2).

ascending_quicksort([], []).
ascending_quicksort([(Head1, Head2)|Tail], Result) :- ascending_pivot((Head1, Head2), Tail, List1, List2), ascending_quicksort(List1, SortedList1), ascending_quicksort(List2, SortedList2), append(SortedList1, [(Head1, Head2)|SortedList2], Result).

descending_pivot(_, [], [], []).
descending_pivot((Pivot1, Pivot2), [(Head1, Head2)|Tail], [(Head1, Head2)|List1], List2) :- Pivot2 < Head2, descending_pivot((Pivot1, Pivot2), Tail, List1, List2).
descending_pivot((Pivot1, Pivot2), [(Head1, Head2)|Tail], List1, [(Head1, Head2)|List2]) :- descending_pivot((Pivot1, Pivot2), Tail, List1, List2).

descending_quicksort([], []).
descending_quicksort([(Head1, Head2)|Tail], Result) :- descending_pivot((Head1, Head2), Tail, List1, List2), descending_quicksort(List1, SortedList1), descending_quicksort(List2, SortedList2), append(SortedList1, [(Head1, Head2)|SortedList2], Result).

printlist([]).
printlist([Head|Tail]) :- write(Head), nl, printlist(Tail).

ascending_order(Result):- merge_cases_to_list(List), ascending_quicksort(List, Result), printlist(Result).
descending_order(Result):- merge_cases_to_list(List), descending_quicksort(List, Result), printlist(Result).
