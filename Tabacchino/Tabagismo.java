/*
 * Tabagismo.java
 * 
 * Copyright 2019 Lince99 <s01118@lab4-pc18>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
 
/*
 * N fumatori richiedono:
 * 		cartina
 * 		tabacco
 * 		filtro
 * 		accendino
 * Ogni fumatore ha in tasca 1 di queste risorse ma in grande quantita'
 * 
 * Tabacchino:
 * 		ha tutte le risorse
 * 		puo' vendere solo 2 risorse alla volta in quantita' limitate
 * 		ogni tot tempo cambia la disponibilita'
 * 						OPPURE
 * 			dopo che un fumatore ha finito
 * 
 * I fumatori hanno bisogno di almeno 1 di tutte le risorse per fumare
 * 
 * 0- Fumatore controlla se ha tutto per fumare:
 * 		0.1- FALSE = Fumatore chiede al tabacchino
 * 		0.2- TRUE  = Fumata per tot tempo
 * 1- Tabacchino offre 2 risorse (lock di quelle rimaste)
 * 3- Fumatori che finiscono di fumare notificano al tabacchino
 * 4- Tabacchino cambia risorse o passa tot tempo e cambia risorse
 * 
 * Una volta finita una delle risorse proponi refill bloccando tutti
 * 	   	o termina programma.
 * Per ogni fumatore mostrare il numero di sigarette fumate
 */
/*
 * COMPONENTI_T:
 * 		nome
 * 		quantita'
 * 
 * TABACCHINO:
 * 		array componenti_t (inizia con tutte le risorse)
 * 		fornisce 2 risorse
 * 		soddisfa fumatori
 * 		attende fumatori
 * 
 * FUMATORE:
 * 		array componenti_t (inizia con 1 risorsa gia' disponibile)
 * 		richiesta al tabacchino (richiede risorse esatte)
 * 		tempo richiesto di fumata, quantita' tabacco fumata, 1 filtro e 1 cartina
 * 		notifica fine fumata
 * 	
 */
/*
 * http://voidexception.weebly.com/multi-threading---using-semaphores.html
 */

public class senza nome {
	
	public static void main (String args[]) {
		//distribuisce risorse al tabacchino
		//
	}
}

