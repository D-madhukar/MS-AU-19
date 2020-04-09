NOW=$(date +"%m%Y"	)
OLDIFS=$IFS
IFS=","
echo $NOW
m1="${NOW:0:2}"
y1="${NOW:3:7}"
while read code type bank number name cvv iDate eDate bDate pin limit
do
	output=$(echo $limit | sed ':a;s/\B[0-9]\{3\}\>/,&/;ta')
	output="$output"
	m="${eDate:0:2}"
	y="${eDate:3:7}"
	if [ $y -gt $y1 ]
  	then
		ans='active'
	elif [$y -eq $y1 -a $m -ge $m1]
	then
		ans='active'
	else 
		ans='expired'        
	fi
	filename="$number.$ans"
	type=$(echo $type | tr -d ' ')
	bank=$(echo $bank | tr -d ' ')
	if [ ! -d "$type" ] 
	then
		mkdir "$type"
	fi	
	if [ ! -d "$type/$bank" ]
	then 
		mkdir "$type/$bank"
	fi	
	path="$type/$bank/$filename"
	touch "$path"
	echo  "Card Type Code: $code" >> "$path"
	echo  "Card Type Full Name: $type" >> "$path"
	echo  "Issuing Bank: $bank" >> "$path"
	echo  "Card Number: $number" >> "$path"
	echo  "Card Holder's Name: $name" >> "$path"
	echo  "CVV/CVV2: $cvv" >> "$path"
	echo  "Issue Date: $iDate" >> "$path"
	echo  "Expiry Date: $eDate" >> "$path"
	echo  "Billing Date: $bDate " >> "$path"
	echo  "Card PIN: $pin" >> "$path"
	echo  "Credit Limit: $ $output" >> "$path"
done < cs.csv
