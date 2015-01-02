package com.example.interface_vfinale;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;


public class Robot
{
	static public Handler m_handler = new Handler() { //refresh aff ou/et recup des donn�es bt pour utilisation
		public void handleMessage(Message msg)
		{
			String myString=(String) msg.obj;
			//Log.i("TextView", myString);	
			//if ( myString !=""){
			   //TextView1.setText(myString);
			   //Log.i("TextView", myString);	
			//}
		}		
	};
	
	
	public Robot(Activity myActivity)
	{
		m_Bluetooth= new BlueT(myActivity, m_handler);
	}
	
	public void connexion()
	{
		m_Bluetooth.connexion();
	}
	
	
	public void MoteurOn ()
	{
		MoteurOn (true, true);
	}
	
	public void MoteurOn (boolean bGauche, boolean bDroite)
	{
		String trame = m_mo;
		
		if (!(bGauche && bDroite))
		{
			if (bGauche)
			{
				trame += m_sep + m_true;
				trame += m_sep + m_false;
			}
			else if (bDroite)
			{
				trame += m_sep + m_false;
				// le deuxieme param est facultatif
			}
			else
			{
				trame += m_sep + m_false;
				trame += m_sep + m_false;
			}
		}
		
		// on pourrait ajouter un toast pour pimenter le tout, mais pas ici !! (ce serait trop fort)
		// cette classe n'est pas cens� le faire
		// de plus il faudrait connaitre l'activit� dans laquelle on le fait
		m_Bluetooth.envoi(trame);
	}
	
	public void MoteurOnG()
	{
		MoteurOnG (true);
	}
	
	public void MoteurOnG (boolean bGauche)
	{
		String trame = m_mog;
		
		if (!(bGauche))
			trame += m_sep + m_false;
		
		m_Bluetooth.envoi(trame);
	}
	
	
	public void MoteurOnD()
	{
		MoteurOnD (true);
	}
	
	public void MoteurOnD (boolean bDroit)
	{
		String trame = m_mod;
		
		if (!(bDroit))
			trame += m_sep + m_false;
		
		m_Bluetooth.envoi(trame);
	}
	
	public void Vitesse (int iVitesse)
	{
		Vitesse (iVitesse, iVitesse);
	}
	
	public void Vitesse (int iVitesseG, int iVitesseD)
	{
		String trame = m_mv;
		
		if ((iVitesseG <= m_iVitesseMax) && (iVitesseG >= 0) && (iVitesseD <= m_iVitesseMax) && (iVitesseD >= 0))
		{
			trame += m_sep + String.valueOf(iVitesseG) + m_sep + String.valueOf(iVitesseD);
		}
		else
		{
			 assert(false) : "erreur de vitesse";
		}
		
		m_Bluetooth.envoi(trame);
	}
	
	public void VitesseG (int iVitesse)
	{
		String trame = m_mvg;
		
		if ((iVitesse <= m_iVitesseMax) && (iVitesse >= 0))
		{
			trame += m_sep + String.valueOf(iVitesse);
		}
		else
		{
			assert(false) : "erreur de vitesse";
		}
		
		m_Bluetooth.envoi(trame);
	}
	
	public void VitesseD (int iVitesse)
	{
		String trame = m_mvd;
		
		if ((iVitesse <= m_iVitesseMax) && (iVitesse >= 0))
		{
			trame += m_sep + String.valueOf(iVitesse);
		}
		else
		{
			assert(false) : "erreur de vitesse";
		}
		
		m_Bluetooth.envoi(trame);
	}
	
	
	public void MoteurAvant()
	{
		MoteurAvant (true, true);
	}
	
	public void MoteurAvant (boolean bGauche, boolean bDroite)
	{
		String trame = m_ma;
		
		if (!(bGauche && bDroite))
		{
			if (bGauche)
			{
				trame += m_sep + m_true;
				trame += m_sep + m_false;
			}
			else if (bDroite)
			{
				trame += m_sep + m_false;
				// le deuxieme param est facultatif
			}
			else
			{
				trame += m_sep + m_false;
				trame += m_sep + m_false;
			}
		}
		
		m_Bluetooth.envoi(trame);
	}
	
	public void MoteurAvantG()
	{
		MoteurAvantG (true);
	}
	
	public void MoteurAvantG (boolean bGauche)
	{
		String trame = m_mag;
		
		if (!(bGauche))
			trame += m_sep + m_false;
		
		m_Bluetooth.envoi(trame);
	}
	
	
	public void MoteurAvantD()
	{
		MoteurAvantD (true);
	}
	
	public void MoteurAvantD (boolean bDroit)
	{
		String trame = m_mad;
		
		if (!(bDroit))
			trame += m_sep + m_false;
		
		m_Bluetooth.envoi(trame);
	}
	
	public void recevoirCaptIR ()
	{
		recevoirCaptIR (true, true, true);
	}
	
	public void recevoirCaptIR (boolean ir1)
	{
		recevoirCaptIR (ir1, true, true);
	}
	
	public void recevoirCaptIR (boolean ir1, boolean ir2)
	{
		recevoirCaptIR (ir1, ir2, true);
	}
	
	public void recevoirCaptIR (boolean ir1, boolean ir2, boolean ir3)
	{
		String trame = m_rir;
		
		if (!(ir1 && ir2 && ir3))
		{
			if (ir1)
				trame += m_sep + m_true;
			else
				trame += m_sep + m_false;
			
			if (!(ir2 && ir3))
			{				
				if (ir2)
				{
					trame += m_sep + m_true;
					trame += m_sep + m_false;
				}
				else if (ir3)
				{
					trame += m_sep + m_false;
					// le troisieme param est facultatif
				}
				else
				{
					trame += m_sep + m_false;
					trame += m_sep + m_false;
				}
			}
		}
		
		m_Bluetooth.envoi(trame);
	}
	
	public void recevoirCaptIRArr()
	{
		recevoirCaptIRArr(true);
	}
	
	public void recevoirCaptIRArr(boolean ir)
	{
		String trame = m_rir1;
		
		if (!ir)
			trame += m_sep + m_false;
		
		m_Bluetooth.envoi(trame);
	}
	
	public void recevoirCaptIRG()
	{
		recevoirCaptIRG(true);
	}
	
	public void recevoirCaptIRG(boolean ir)
	{
		String trame = m_rir2;
		
		if (!ir)
			trame += m_sep + m_false;
		
		m_Bluetooth.envoi(trame);
	}
	
	public void recevoirCaptIRD()
	{
		recevoirCaptIRD(true);
	}
	
	public void recevoirCaptIRD(boolean ir)
	{
		String trame = m_rir3;
		
		if (!ir)
			trame += m_sep + m_false;
		
		m_Bluetooth.envoi(trame);
	}
	
	
	public void setCaptIRArr()
	{
		setCaptIRArr(true);
	}
	
	public void setCaptIRArr(boolean capteur)
	{
		m_captIRArr = capteur;
	}
	
	public void setCaptIRG()
	{
		setCaptIRG(true);
	}
	
	public void setCaptIRG(boolean capteur)
	{
		m_captIRG = capteur;
	}
	
	public void setCaptIRD()
	{
		setCaptIRD(true);
	}
	
	public void setCaptIRD(boolean capteur)
	{
		m_captIRD = capteur;
	}
	
	public void setDistance(int dst)
	{
		if (dst >= -1 && dst < 1000)
			m_distance = dst;
	}
	
	
	
	//declaration des elements de la trame
	
	private final static String m_sep = ","; //virgule de separation dans la trame
	
	private final static String m_mo  = "1";  // "1" moteur on
	private final static String m_mog = "2";  // "2" moteur on gauche
	private final static String m_mod = "3";  // "3" moteur on droit
	
	private final static String m_mv  = "4";
	private final static String m_mvg = "5";
	private final static String m_mvd = "6";
	
	private final static String m_ma  = "7";
	private final static String m_mag = "8";
	private final static String m_mad = "9";
	
	private final static String m_rir = "10";
	private final static String m_rir1 = "11";
	private final static String m_rir2 = "12";
	private final static String m_rir3 = "13";
	
	private final static String m_rus = "14";
	
	private final static String m_true  = "1";
	private final static String m_false = "0";
	
	//private final static String m_fin = "\0";
	
	private final static int m_iVitesseMax = 10;
	
	
	private boolean m_captIRArr;
	private boolean m_captIRG;
	private boolean m_captIRD;
	
	private int m_distance;
	
	
	private BlueT m_Bluetooth;
}


