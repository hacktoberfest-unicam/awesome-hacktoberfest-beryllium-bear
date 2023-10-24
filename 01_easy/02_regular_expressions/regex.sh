echo "casa/NOUN albero/NOUN verde/ADJ gatto/NOUN rosso/ADJ
Marta/WOM Giorgio/MAN Nick/MAN Alessandra/WOM Francesco/MAN
ciao/CIAO
telefono/TEL
cerchio/CERC
?/QUEST" | grep -Eo '[^ ]+/[A-Z]{2,4}' | sed 's|/\([A-Z]\{2,4\}\)$||'
