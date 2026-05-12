import React from 'react';
import { Smartphone, Camera, MapPin, Database, Cloud, CheckCircle2, ChevronRight, Search, Plus, BarChart3, Clock, AlertTriangle } from 'lucide-react';
import { motion } from 'motion/react';

export default function App() {
  return (
    <div className="min-h-screen bg-slate-50 font-sans text-slate-900 flex flex-col">
      {/* Professional Header */}
      <header className="h-16 bg-brand-blue text-white flex items-center justify-between px-8 shadow-md shrink-0">
        <div className="flex items-center gap-3">
          <div className="w-10 h-10 bg-white rounded-lg flex items-center justify-center shadow-lg">
            <Smartphone className="text-brand-blue w-6 h-6" />
          </div>
          <h1 className="text-xl font-bold tracking-tight">Namma-Raste Reporter</h1>
        </div>
        <div className="flex items-center gap-6">
          <div className="hidden sm:flex flex-col items-end">
            <span className="text-[10px] opacity-70 uppercase font-bold tracking-wider">System Status</span>
            <span className="text-xs font-semibold flex items-center gap-1.5">
              <span className="w-2 h-2 rounded-full bg-green-400 animate-pulse"></span>
              Live & Deployed
            </span>
          </div>
          <div className="w-10 h-10 rounded-full bg-blue-500 border-2 border-white/20 flex items-center justify-center font-bold text-sm shadow-inner cursor-pointer hover:bg-blue-400 transition-colors">
            NR
          </div>
        </div>
      </header>

      <main className="flex-1 p-4 sm:p-8 grid grid-cols-12 gap-6 max-w-[1440px] mx-auto w-full">
        {/* Left Column: Primary Actions & Reports */}
        <div className="col-span-12 lg:col-span-8 flex flex-col gap-6">
          {/* Welcome & Quick Action Card */}
          <section className="bg-white rounded-2xl shadow-sm border border-slate-200 p-8 flex flex-col sm:flex-row items-center justify-between gap-6 overflow-hidden relative group">
            <div className="absolute -right-12 -top-12 w-48 h-48 bg-blue-50 rounded-full opacity-50 blur-3xl group-hover:bg-blue-100 transition-colors"></div>
            
            <div className="relative z-10 max-w-md">
              <span className="inline-block px-3 py-1 rounded-full bg-blue-50 text-brand-blue text-[10px] font-bold uppercase tracking-wider mb-4">Android Project Core</span>
              <h2 className="text-3xl font-black text-slate-800 mb-2 leading-tight">Civic Reporting Made Simple.</h2>
              <p className="text-slate-500 mb-8 leading-relaxed">
                Namma-Raste (Our Road) is a camera-based reporter system. High-performance, location-aware, and offline-ready.
              </p>
              <div className="flex flex-wrap gap-4">
                <button className="bg-brand-blue hover:bg-brand-blue/90 text-white px-6 py-3 rounded-xl font-bold flex items-center gap-2 shadow-lg shadow-blue-200 transition-all active:scale-95">
                  <Plus size={18} />
                  New Report
                </button>
                <button className="bg-slate-100 hover:bg-slate-200 text-slate-700 px-6 py-3 rounded-xl font-semibold transition-all">
                  Documentation
                </button>
              </div>
            </div>

            <div className="relative z-10 w-full sm:w-64 h-40 bg-slate-50 rounded-2xl border-2 border-dashed border-slate-200 flex flex-col items-center justify-center text-slate-400 group-hover:border-blue-200 group-hover:text-blue-400 transition-all">
              <Camera size={32} className="mb-2 opacity-50" />
              <span className="text-xs font-bold uppercase tracking-widest">CameraX Preview</span>
            </div>
          </section>

          {/* Recent Reports Table */}
          <section className="bg-white rounded-2xl shadow-sm border border-slate-200 flex flex-col flex-1 overflow-hidden min-h-[400px]">
            <div className="px-6 py-4 border-b border-slate-100 flex items-center justify-between bg-slate-50/50">
              <h3 className="font-bold text-slate-800 flex items-center gap-2 text-sm uppercase tracking-wider">
                <BarChart3 size={16} className="text-blue-600" />
                Live Feed (Mock Data)
              </h3>
              <a href="#" className="text-xs text-brand-blue font-bold flex items-center gap-1 hover:underline">
                View Repository <ChevronRight size={14} />
              </a>
            </div>
            <div className="flex-1 overflow-auto">
              <table className="w-full text-left border-collapse">
                <thead className="sticky top-0 bg-white/80 backdrop-blur-md border-b border-slate-100 z-10">
                  <tr className="text-[10px] uppercase text-slate-400 font-bold tracking-widest">
                    <th className="px-6 py-4">Ticket ID</th>
                    <th className="px-6 py-4">Issue Type</th>
                    <th className="px-6 py-4 text-center">Location</th>
                    <th className="px-6 py-4">Status</th>
                  </tr>
                </thead>
                <tbody className="divide-y divide-slate-50 text-sm">
                  {[
                    { id: 'NR-2026-0412', type: 'Pothole', color: 'bg-orange-500', location: 'Indiranagar', status: 'In Progress', statusColor: 'bg-blue-50 text-blue-700' },
                    { id: 'NR-2026-0389', type: 'Streetlight', color: 'bg-amber-400', location: 'Koramangala', status: 'Resolved', statusColor: 'bg-green-50 text-green-700' },
                    { id: 'NR-2026-0382', type: 'Pothole', color: 'bg-orange-500', location: 'HSR Layout', status: 'Under Review', statusColor: 'bg-slate-100 text-slate-600' },
                    { id: 'NR-2026-0371', type: 'Pothole', color: 'bg-orange-500', location: 'Whitefield', status: 'Resolved', statusColor: 'bg-green-50 text-green-700' },
                  ].map((report, i) => (
                    <motion.tr 
                      key={report.id}
                      initial={{ opacity: 0, x: -10 }}
                      animate={{ opacity: 1, x: 0 }}
                      transition={{ delay: i * 0.1 }}
                      className="hover:bg-blue-50/30 transition-colors cursor-default group"
                    >
                      <td className="px-6 py-4 font-mono text-brand-blue font-bold text-xs">{report.id}</td>
                      <td className="px-6 py-4">
                        <div className="flex items-center gap-2.5">
                          <div className={`w-2 h-2 rounded-full ${report.color} shadow-sm`}></div>
                          <span className="font-semibold text-slate-700">{report.type}</span>
                        </div>
                      </td>
                      <td className="px-6 py-4 text-center text-slate-500 text-xs font-medium">{report.location}</td>
                      <td className="px-6 py-4">
                        <span className={`px-2.5 py-1 rounded-lg text-[10px] font-black uppercase tracking-wider ${report.statusColor}`}>
                          {report.status}
                        </span>
                      </td>
                    </motion.tr>
                  ))}
                </tbody>
              </table>
            </div>
          </section>
        </div>

        {/* Right Column: Status & Impact */}
        <div className="col-span-12 lg:col-span-4 flex flex-col gap-6">
          {/* Tracker Card */}
          <section className="bg-white rounded-2xl shadow-sm border border-slate-200 p-6 shadow-indigo-100">
            <h3 className="font-bold text-slate-800 mb-4 flex items-center gap-2">
              <Search size={18} className="text-slate-400" />
              Status Tracker
            </h3>
            <div className="space-y-3">
              <div className="relative">
                <input 
                  type="text" 
                  placeholder="Ticket ID (e.g. NR-2026-0001)" 
                  className="w-full pl-4 pr-10 py-3 bg-slate-50 border border-slate-200 rounded-xl text-sm focus:ring-2 focus:ring-blue-500 focus:bg-white outline-none transition-all placeholder:text-slate-300"
                />
              </div>
              <button className="w-full bg-slate-800 text-white py-3 rounded-xl font-bold hover:bg-slate-900 transition-all active:scale-[0.98] shadow-lg shadow-slate-200">
                Track Report
              </button>
            </div>
          </section>

          {/* Impact & AI Card */}
          <section className="bg-white rounded-2xl shadow-sm border border-slate-200 p-8 flex-1 flex flex-col">
            <div className="flex items-center justify-between mb-8">
              <h3 className="font-black text-slate-800 text-sm uppercase tracking-widest">Global Analytics</h3>
              <div className="bg-blue-50 p-2 rounded-lg text-blue-600">
                <BarChart3 size={20} />
              </div>
            </div>
            
            <div className="grid grid-cols-2 gap-4 mb-8">
              <AnalyticsItem label="Total Reports" value="1,248" trend="+12%" color="blue" />
              <AnalyticsItem label="Resolved" value="892" trend="+8%" color="green" />
              <AnalyticsItem label="Crit. Issues" value="42" color="orange" icon={<AlertTriangle size={12}/>} />
              <AnalyticsItem label="Avg. Response" value="3.2d" color="slate" icon={<Clock size={12}/>} />
            </div>

            <div className="mt-auto pt-8 border-t border-slate-100">
              <div className="flex items-center justify-between mb-4">
                <div className="flex items-center gap-2">
                  <h4 className="text-xs font-black text-slate-700 uppercase tracking-tight">AI Severity Check</h4>
                  <span className="text-[9px] px-1.5 py-0.5 bg-blue-100 text-brand-blue rounded font-bold">BETA</span>
                </div>
                <span className="text-[10px] font-black text-brand-blue">94.2%</span>
              </div>
              <div className="h-2 bg-slate-100 rounded-full overflow-hidden mb-3">
                <motion.div 
                   initial={{ width: 0 }}
                   animate={{ width: '94.2%' }}
                   transition={{ duration: 1, ease: 'easeOut' }}
                   className="h-full bg-gradient-to-r from-blue-400 to-brand-blue"
                />
              </div>
              <p className="text-[11px] text-slate-400 leading-relaxed italic">
                CV models are accurately detecting pothole depth using image segmentation.
              </p>
            </div>
          </section>

          {/* Footer Branding */}
          <footer className="text-center py-4">
            <p className="text-[9px] text-slate-300 font-black uppercase tracking-[0.25em]">
              Powered by Namma-Raste Gov. Initiatives
            </p>
          </footer>
        </div>
      </main>
    </div>
  );
}

function AnalyticsItem({ label, value, trend, color, icon }: { label: string, value: string, trend?: string, color: string, icon?: React.ReactNode }) {
  const colors: Record<string, string> = {
    blue: 'bg-blue-50 text-blue-600 border-blue-100',
    green: 'bg-green-50 text-green-600 border-green-100',
    orange: 'bg-orange-50 text-orange-600 border-orange-100',
    slate: 'bg-slate-50 text-slate-600 border-slate-100',
  };

  return (
    <div className={`p-4 rounded-2xl border ${colors[color]} flex flex-col gap-1`}>
      <div className="flex justify-between items-start">
        <span className="text-[10px] font-bold uppercase tracking-tight opacity-70">{label}</span>
        {icon}
      </div>
      <div className="flex items-baseline gap-1.5">
        <span className="text-xl font-black text-slate-800 tracking-tight">{value}</span>
        {trend && <span className="text-[9px] font-bold opacity-80">{trend}</span>}
      </div>
    </div>
  );
}
