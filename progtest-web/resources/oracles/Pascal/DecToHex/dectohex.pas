program dectohex(input, output);

const
	MAX = 16;
	BASE = 16;

var
	i, j, remainder, number : integer;
	hexno : array[1..MAX] of char;

begin
	readln(number);
	i := 1;
	while (number > 0) do begin
		remainder := number mod BASE;
		number := number div BASE;
		if (remainder < 10) then
			hexno[i] := chr(ord('0') + remainder)
		else
			hexno[i] := chr(ord('A') + remainder - 10);
		i := i + 1;
	end;

	for j := (i - 1) downto 1 do
		write(hexno[j]);
	writeln;
end.
