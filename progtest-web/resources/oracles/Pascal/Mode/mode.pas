program calcmode(input, output);

const
	MAX = 10;

var
	i, num, mode, maxfreq : integer;
	freq : array [1..MAX] of integer;

begin
	(* Initialize frequencies *)
	for i := 1 to max do
		freq[i] := 0;

	(* Read in numbers and update frequencies. *)
	repeat
		read(num);
		freq[num] := freq[num] + 1
	until eoln;

	(* Initialize the mode to the first element read *)
	mode := 1;
	maxfreq := freq[1];

	(* Find the mode *)
	for i := 2 to MAX do
		if (freq[i] > maxfreq) then begin
			mode := 1;
			maxfreq := freq[i];
		end;

	writeln(mode);
end.
